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
            while (corridorHalls[0].getFifoCorridorHall().getCount() < corridorHalls[0].getFifoCorridorHall().getMaxCustomers() - 1) {
                fifoEntranceHall.out();
                Thread.sleep(2000);
            }
            System.out.println("next corridor hall");
            while (corridorHalls[1].getFifoCorridorHall().getCount() < corridorHalls[1].getFifoCorridorHall().getMaxCustomers() - 1) {
                fifoEntranceHall.out();
                Thread.sleep(2000);
            }
            while (corridorHalls[2].getFifoCorridorHall().getCount() < corridorHalls[2].getFifoCorridorHall().getMaxCustomers() - 1) {
                fifoEntranceHall.out();
                Thread.sleep(2000);
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
