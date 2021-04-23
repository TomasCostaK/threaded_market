/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SACorridorHall;
import Communication.NotifyCustomerState;

import java.util.HashMap;
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
    private HashMap<Integer, Integer> positions;
    private boolean corridorHasSpace;

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
        this.positions = new HashMap<Integer, Integer>();
        this.corridorHasSpace = false;
    }
    

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("CorridorHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {id, position});
        fifoCorridorHall.in(customerId);
  
    }
    
    @Override
    public void out(int customerId) {
        // before leaving, awaits checking if corridor is clear
        try {
            while (!checkCorridor()) {
            }
            fifoCorridorHall.out();
            this.customersPosition[positions.get(customerId)] = -1; 
        } catch (Exception e ) {};
 
        //System.out.println("Customer leaving CorridorHall.");
    }

    @Override
    public boolean checkCorridor() {
        //System.out.println("Corridor " + id + " Count: " + corridor.getFifoCorridor().getCount() + " Size: " + corridor.getFifoCorridor().getSize());
        corridorHasSpace = corridor.getFifoCorridor().hasSpace();
        return corridorHasSpace;

        
    }
   
    private int selectPositionInGUI(int customerId){
        
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        
        positions.put(customerId, position);
        
        return position;
        
        
    } 
    
    public Queue getFifoCorridorHall() {
        return this.fifoCorridorHall;
    }

}
