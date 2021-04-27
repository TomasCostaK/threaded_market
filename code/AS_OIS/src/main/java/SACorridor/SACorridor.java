/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SACorridor;
import Communication.NotifyCustomerState;

import FIFO.Queue;
import Main.OIS_GUI;
import SAPaymentHall.SAPaymentHall;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omp
 */
public class SACorridor implements ICorridor_Customer,
                                       ICorridor_Control {
    
    final Queue fifoCorridor;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final NotifyCustomerState notify;
    private final int id;
    private final int customersPosition[];
    final SAPaymentHall paymentHall;
    private boolean suspended;

    public SACorridor( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, int id, SAPaymentHall paymentHall ) {
        this.fifoCorridor = new Queue<Integer>(maxCustomers);
        this.GUI = GUI;
        this.totalCustomers = maxCustomers;
        this.id = id;
        this.notify = notify;
        this.customersPosition = new int[10];
        for(int i = 0; i < 10; i ++){
            this.customersPosition[i] = -1;
        }
        this.paymentHall = paymentHall;
        this.suspended = false;
    }
    

    @Override
    public void in(int customerId, int cto) {
        try {
            //System.out.println("corridor " + id + " size: "+fifoCorridor.getSize());
            //System.out.println("corridor " + id + " count:   "+fifoCorridor.getCount());
            fifoCorridor.in(customerId);
            notify.sendCustomerState("Corridor", customerId);
            forward(customerId, cto);
        } catch (Exception e) {};
        
    }
    
    @Override
    public void out() {
        // While there is space in the corridor queue, go for it
        fifoCorridor.out();
    }

    // Check if there is no one in front of the customer, so they dont advance to the same tile
    @Override
    public void checkTreadmill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Blocking condition, keeps moving forward until checkTreadmill returns that there is someone in front
    public void forward(int customerId, int cto) {
        while(true){
            try {
            int previous_position = 0;
            for(int i=0; i<10; i++) {
                int position = i;
                while(this.customersPosition[position] != -1) {
                    Thread.sleep(1500);
                } //stuck in a loop,               
                this.customersPosition[previous_position] = -1;
                this.customersPosition[position] = customerId;
                while(true){
                    if (!this.suspended) {
                        if (position==9) {  
                            GUI.moveCustomer(customerId, new Integer[] {id, position});
                            System.out.println("Customer "+customerId+" trying to enter PaymentHall, count is: " + paymentHall.getFifoPaymentHall().getCount());
                            paymentHall.in(customerId);
                            // It will never get here, this is wrong
                            previous_position = position;
                            this.customersPosition[previous_position] = -1;
                            out();
                            return;
                        }
                        else {
                            GUI.moveCustomer(customerId, new Integer[] {id, position});
                            Thread.sleep(cto);  
                            previous_position = position;
                        }
                        break;
                    }
                    else {
                        Thread.sleep(1500);
                    }
                }
            }
            } catch (InterruptedException ex) {
                Logger.getLogger(SACorridor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    public Queue getFifoCorridor() {
        return this.fifoCorridor;
    }

    @Override
    public void suspend() {
        this.suspended = true;
    }

    @Override
    public void resume() {
        this.suspended = false;
    }
}

