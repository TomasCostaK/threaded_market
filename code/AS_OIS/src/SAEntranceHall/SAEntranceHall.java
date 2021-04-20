/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAEntranceHall;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import Main.OIS_GUI;

/**
 *
 * @author omp
 */
public class SAEntranceHall implements IEntranceHall_Customer,
                                       IEntranceHall_Manager,
                                       IEntranceHall_Control {
    
    final FIFO fifoEntranceHall;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;

    public SAEntranceHall( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify ) {
        this.fifoEntranceHall = new FIFO(maxCustomers);
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
            System.out.println("FIFO Entrance: " + fifoEntranceHall.getCount());
            fifoEntranceHall.out();
            break;
        }
    }

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("EntranceHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {1, position});
        int customerLeaving = fifoEntranceHall.in(customerId);
        System.out.println("Customer " + customerLeaving + " leaving EntranceHall.");   
    }
   
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    } 
}
