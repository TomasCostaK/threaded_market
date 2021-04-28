/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAPaymentPoint;
import Communication.NotifyCustomerState;

import FIFO.Queue;
import Main.OIS_GUI;

public class SAPaymentPoint implements IPaymentPoint_Customer,
                                       IPaymentPoint_Cashier,
                                       IPaymentPoint_Control {
    
    final Queue fifoPaymentBox;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;
    private final int id;
    private int customerLeaving;
    private boolean suspended;
    private boolean stopped;
    private boolean ended;

    public SAPaymentPoint( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, int id ) {
        this.fifoPaymentBox = new Queue<Integer>(maxCustomers);
        this.GUI = GUI;
        this.customerLeaving = -1;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.id = id;
        this.notify = notify;
        this.suspended = false;
        this.stopped = false;
        this.ended = false;
    }
    
    @Override
    public void process() {
        if (this.fifoPaymentBox.getCount() > 0){
            System.out.println("Cashier processing payment");
            this.fifoPaymentBox.out();
            this.customersPosition[0] = -1;
            // Signaling its over
            this.notify.sendCustomerState("Terminated", this.customerLeaving);
            this.GUI.moveCustomer(this.customerLeaving, new Integer[] {10, this.customerLeaving});
        }
    }

    @Override
    public int in(int customerId) {
        while(true){
            if (this.fifoPaymentBox.hasSpace()){
                this.fifoPaymentBox.in(customerId);
                this.notify.sendCustomerState("PaymentPoint", customerId);
                int position = this.selectPositionInGUI(customerId);
                this.GUI.moveCustomer(customerId, new Integer[] {id, position});
                this.customerLeaving = customerId;
                this.customersPosition[position] = -1;
                if (this.stopped) {
                    return 1;
                }
                else if(this.ended) return 2;
                return 0;
            }
            else {
                try {
                    if (this.stopped) {
                        return 1;
                    }
                    else if(this.ended) return 2;
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {}
            }
        }

    }
    
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        while(this.customersPosition[position] != -1) position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        this.customersPosition[position] = customerId;
        return position;
    } 
    
    public Queue getFifoPaymentPoint() {
        return this.fifoPaymentBox;
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

}
