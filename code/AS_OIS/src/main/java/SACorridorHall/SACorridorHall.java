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
    private boolean suspended;
    private boolean stopped;
    private boolean ended;

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
        this.suspended = false;
        this.stopped = false;
        this.ended = false;
    }
    

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("CorridorHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {id, position});
        fifoCorridorHall.in(customerId);        
    }
    
    @Override
    public int out(int customerId) {
        // before leaving, awaits checking if corridor is clear
        try {
            while (!checkCorridor()) {
                if (this.stopped) {
                    fifoCorridorHall.out();
                    return 1;
                }
                else if(this.ended) return 2;
                else Thread.sleep(100);
            }
            while (true) {
                if (!this.suspended) {
                    fifoCorridorHall.out();
                    this.customersPosition[positions.get(customerId)] = -1; 
                    break;
                }
                else {
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e ) {};
        return 0;
 
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
    
    
    @Override
    public void suspend() {
        this.suspended = true;
    }

    @Override
    public void resume() {
        this.suspended = false;
    }
    
    @Override
    public void stop() {
        this.stopped = true;
    }

    @Override 
    public void end() {
        this.ended = true;
    }
    
    @Override
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

}