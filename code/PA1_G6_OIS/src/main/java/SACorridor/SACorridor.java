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
    private boolean stopped;
    private boolean ended;

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
        this.stopped = false;
        this.ended = false;
    }
    

    @Override
    public int in(int customerId, int cto) {
        int stop = 0;
        try {
            //System.out.println("corridor " + id + " size: "+fifoCorridor.getSize());
            //System.out.println("corridor " + id + " count:   "+fifoCorridor.getCount());
            this.fifoCorridor.in(customerId);
            this.notify.sendCustomerState("Corridor", customerId);
            stop = forward(customerId, cto);
        } catch (Exception e) {};
        return stop;
    }
    
    @Override
    public void out() {
        // While there is space in the corridor queue, go for it
        this.fifoCorridor.out();
    }

    // Check if there is no one in front of the customer, so they dont advance to the same tile
    @Override
    public void checkTreadmill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Blocking condition, keeps moving forward until checkTreadmill returns that there is someone in front
    public int forward(int customerId, int cto) {
        while(true){
            try {
            int previous_position = 0;
            for(int i=0; i<10; i++) {
                int position = i;
                while(this.customersPosition[position] != -1) {
                    Thread.sleep(1500);
                }               
                this.customersPosition[previous_position] = -1;
                this.customersPosition[position] = customerId;
                System.out.println(this.stopped);
                if(this.stopped) return 1;
                else if(this.ended) return 2;
                while(true){
                    if (!this.suspended) {
                        if (position==9) {  
                            GUI.moveCustomer(customerId, new Integer[] {this.id, position});
                            //System.out.println("PaymentHall count is: " + paymentHall.getFifoPaymentHall().getCount());
                            while (true) {
                                if (!this.suspended) {
                                    if(this.paymentHall.getFifoPaymentHall().hasSpace()) { 
                                        System.out.println("Customer "+customerId+" going in payment");
                                        this.paymentHall.in(customerId);
                                        Thread.sleep(cto);
                                        previous_position = position;
                                        this.customersPosition[previous_position] = -1;
                                        out();
                                        if(this.stopped) return 1;
                                        else if(this.ended) return 2;
                                        break;
                                    }
                                    else Thread.sleep(1000);
                                    if(this.stopped) return 1;
                                    else if(this.ended) return 2;
                                }
                                else Thread.sleep(1000);
                            }
                            return 0;
                        }
                        else {
                            this.GUI.moveCustomer(customerId, new Integer[] {this.id, position});
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
            } catch (InterruptedException ex) {}
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
    
    @Override
    public void stop() {
        this.stopped = true;
    }
    
    @Override 
    public void end() {
        this.ended = true;
    }
    
    @Override
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
    
    public void setInitialPositions() {
        for(int i = 0; i < 10; i ++){
            this.customersPosition[i] = -1;
        }
    }
}

