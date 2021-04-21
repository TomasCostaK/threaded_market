/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAEntranceHall;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import Main.OIS_GUI;
import SACorridorHall.SACorridorHall;

/**
 *
 * @author omp
 */
public class SAEntranceHall implements IEntranceHall_Customer,
                                       IEntranceHall_Manager,
                                       IEntranceHall_Control {
    
    private final FIFO fifoEntranceHall;
    private final SACorridorHall[] corridorHalls;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;

    public SAEntranceHall( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, SACorridorHall[] corridorHalls ) {
        this.fifoEntranceHall = new FIFO(maxCustomers);
        this.GUI = GUI;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.notify = notify;
        this.corridorHalls = corridorHalls;
    }
    
    @Override
    public void call() {
        try {
            while (true) {
                if (fifoEntranceHall.getCount() < 1) {
                    Thread.sleep(2000);
                    return;
                }

                if (corridorHalls[0].getFifoCorridorHall().hasSpace()) {
                    fifoEntranceHall.out();
                    Thread.sleep(2000);
                    continue;
                }
                System.out.println("Going for corridor 2");
                if (corridorHalls[1].getFifoCorridorHall().hasSpace()) {
                    fifoEntranceHall.out();
                    Thread.sleep(2000);
                    continue;
                }
                System.out.println("Going for corridor 3");
                if (corridorHalls[2].getFifoCorridorHall().hasSpace()) {
                    fifoEntranceHall.out();
                    Thread.sleep(2000);;
                    continue;
                }
            }
        }
        catch(Exception e) {}    
    }
    @Override
    public void in(int customerId) {
        notify.sendCustomerState("EntranceHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {1, position});
        int customerLeaving = fifoEntranceHall.in(customerId);
        //System.out.println("Customer " + customerLeaving + " leaving EntranceHall.");   
    }
   
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    } 
    
    public FIFO getFifoEntranceHall() {
        return this.fifoEntranceHall;
    }
}
