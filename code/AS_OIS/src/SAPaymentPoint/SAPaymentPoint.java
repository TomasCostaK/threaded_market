/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAPaymentPoint;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import Main.OIS_GUI;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final int id;
    private int customerLeaving;

    public SAPaymentPoint( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, int id ) {
        this.fifoPaymentBox = new FIFO(maxCustomers);
        this.GUI = GUI;
        this.customerLeaving = -1;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.id = id;
        this.notify = notify;
    }
    
    @Override
    public void process() {
        if (fifoPaymentBox.getCount() > 0){
            System.out.println("CustomerX: "+customerLeaving+ " is leaving the store.");
            fifoPaymentBox.out();
            // Signaling its over
            notify.sendCustomerState("Terminated", customerLeaving);
            GUI.moveCustomer(customerLeaving, new Integer[] {id+1, customerLeaving});
        }
    }

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("PaymentPoint", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {id, position});
        this.customerLeaving = customerId;
        fifoPaymentBox.in(customerId);
    }
    
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    } 
    
    public FIFO getFifoPaymentPoint() {
        return this.fifoPaymentBox;
    }

}
