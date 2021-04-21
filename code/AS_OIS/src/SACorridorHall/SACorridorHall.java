/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SACorridorHall;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import FIFO.Queue;
import Main.OIS_GUI;
import SACorridor.SACorridor;

/**
 *
 * @author omp
 */
public class SACorridorHall implements ICorridorHall_Customer,
                                       ICorridorHall_Control {
    
    final Queue fifoCorridorHall;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;
    private final int id;
    private final SACorridor corridor;

    public SACorridorHall( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, int id , SACorridor corridor) {
        this.fifoCorridorHall = new Queue<Integer>(maxCustomers);
        this.GUI = GUI;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.notify = notify;
        this.id = id;
        this.corridor = corridor;
    }
    

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("CorridorHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {id, position});
        fifoCorridorHall.in(customerId);
    }
    
    @Override
    public void out() {
        // before leaving, awaits checking if corridor is clear
        while (checkCorridor() == false) {
            try {
                System.out.println("No space in corridor; Sleeping.");
                Thread.sleep(2500);
            } catch (Exception e){
                System.out.println("Thread failed to sleep");
            }

        }
        fifoCorridorHall.out();
        System.out.println("Customer leaving CorridorHall.");
    }

    @Override
    public boolean checkCorridor() {
        return corridor.getFifoCorridor().hasSpace();
    }
   
    private int selectPositionInGUI(int customerId){
        
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        
        System.out.println(position);
        return position;
        
        
    } 
    
    public Queue getFifoCorridorHall() {
        return this.fifoCorridorHall;
    }

}
