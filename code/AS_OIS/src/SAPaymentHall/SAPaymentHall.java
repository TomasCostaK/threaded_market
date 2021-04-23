/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAPaymentHall;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import Main.OIS_GUI;

/**
 *
 * @author omp
 */
public class SAPaymentHall implements IPaymentHall_Customer,
                                       IPaymentHall_Cashier,
                                       IPaymentHall_Control {
    
    final FIFO fifoPaymentHall;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;

    public SAPaymentHall( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify ) {
        this.fifoPaymentHall = new FIFO(maxCustomers);
        this.GUI = GUI;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.notify = notify;
    }
    
    @Override
    public void call() {
        while (true) {
            fifoPaymentHall.out();
        }
    }

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("PaymentHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {1, position});
        int customerLeaving = fifoPaymentHall.in(customerId);
        System.out.println("Customer " + customerLeaving + " leaving PaymentHall.");   
    }
    
    @Override
    public void notifyCashier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    } 

}