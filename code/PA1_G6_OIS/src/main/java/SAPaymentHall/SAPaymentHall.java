/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAPaymentHall;
import Communication.NotifyCustomerState;

import FIFO.Queue;
import Main.OIS_GUI;
import SAPaymentPoint.SAPaymentPoint;

public class SAPaymentHall implements IPaymentHall_Customer,
                                       IPaymentHall_Cashier,
                                       IPaymentHall_Control {
    
    final Queue fifoPaymentHall;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;
    final SAPaymentPoint paymentPoint;
    private final int id;


    public SAPaymentHall( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, int id , SAPaymentPoint paymentPoint ) {
        this.fifoPaymentHall = new Queue<Integer>(maxCustomers);
        this.GUI = GUI;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.id = id;
        this.notify = notify;
        this.paymentPoint = paymentPoint;
    }
    
    @Override
    public void call() {
        try {
            while (this.fifoPaymentHall.getCount() > 0 && this.paymentPoint.getFifoPaymentPoint().hasSpace()) {
                System.out.println("Cashier calling people in paymentHall");
                this.fifoPaymentHall.out();
                Thread.sleep(200);
            }
        }
        catch(Exception e) {}    
    }

    @Override
    public void in(int customerId) {
        while(true){
            if (this.fifoPaymentHall.hasSpace()){
                this.notify.sendCustomerState("PaymentHall", customerId);
                int position = this.selectPositionInGUI(customerId);
                this.GUI.moveCustomer(customerId, new Integer[] {id, position});
                this.fifoPaymentHall.in(customerId);
                this.customersPosition[position] = -1;
                return;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }

    }
    
    @Override
    public void notifyCashier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        while(this.customersPosition[position] != -1) position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        this.customersPosition[position] = customerId;
        return position;
    } 

    public Queue getFifoPaymentHall() {
        return this.fifoPaymentHall;
    }
}
