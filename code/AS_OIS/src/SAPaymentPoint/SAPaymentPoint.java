/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAPaymentPoint;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import Main.OIS_GUI;

/**
 *
 * @author tomascosta
 */
public class SAPaymentPoint implements IPaymentPoint_Customer,
                                       IPaymentPoint_Cashier,
                                       IPaymentPoint_Control {
    
    final FIFO fifoPaymentBox;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;

    public SAPaymentPoint( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify ) {
        this.fifoPaymentBox = new FIFO(maxCustomers);
        this.GUI = GUI;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.notify = notify;
    }
    
    @Override
    public void process() {
        while (true) {
            fifoPaymentBox.out();
        }
    }

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("PaymentPoint", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {1, position});
        int customerLeaving = fifoPaymentBox.in(customerId);
        System.out.println("Customer " + customerLeaving + " leaving store.");   
    }
    
   
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    } 

}
