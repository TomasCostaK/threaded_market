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
    }
    

    @Override
    public void in(int customerId, int cto) {
        try {
            //System.out.println("corridor " + id + " size: "+fifoCorridor.getSize());
            //System.out.println("corridor " + id + " count:   "+fifoCorridor.getCount());
            fifoCorridor.in(customerId);
            notify.sendCustomerState("Corridor", customerId);
            int previous_position = 0;
            for(int i=0; i<10; i++) {
                int position = i;
                while(this.customersPosition[position] != -1) {
                    
                }
                
                this.customersPosition[previous_position] = -1;
                this.customersPosition[position] = customerId;
                if (position==9) {  // last position in corridor (aqui parar porque o resto ainda não está feito)
                    GUI.moveCustomer(customerId, new Integer[] {id, position});
                    System.out.println("Customer "+customerId+" trying to enter PaymentHall, count is: " + paymentHall.getFifoPaymentHall().getCount());
                    paymentHall.in(customerId);
                    // It will never get here, this is wrong
                    previous_position = position;
                    this.customersPosition[previous_position] = -1;
                    out();
                }
                else {
                    GUI.moveCustomer(customerId, new Integer[] {id, position});
                    Thread.sleep(cto);  
                    previous_position = position;
                }
                
            }
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
    @Override
    public void forward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public Queue getFifoCorridor() {
        return this.fifoCorridor;
    }

}
