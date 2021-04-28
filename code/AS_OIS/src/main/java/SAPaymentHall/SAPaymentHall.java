/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAPaymentHall;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import Main.OIS_GUI;
import SAPaymentPoint.SAPaymentPoint;
import java.util.concurrent.TimeUnit;


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
    final SAPaymentPoint paymentPoint;
    private final int id;


    public SAPaymentHall( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, int id , SAPaymentPoint paymentPoint ) {
        this.fifoPaymentHall = new FIFO(maxCustomers);
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
            if (fifoPaymentHall.getCount() > 0 && paymentPoint.getFifoPaymentPoint().getCount() < paymentPoint.getFifoPaymentPoint().getMaxCustomers()) {
                System.out.println("Cashier calling people in paymentHall");
                fifoPaymentHall.out();
            }
        }
        catch(Exception e) {}    
    }

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("PaymentHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {id, position});
        fifoPaymentHall.in(customerId);
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

    public FIFO getFifoPaymentHall() {
        return this.fifoPaymentHall;
    }
}
