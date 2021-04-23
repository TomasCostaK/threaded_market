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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
    private int corridorHall_number;
    private final ReentrantLock rl = new ReentrantLock( true );
    private boolean suspended;
    private final Condition suspend;

    public SAEntranceHall( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, SACorridorHall[] corridorHalls ) {
        this.fifoEntranceHall = new FIFO(maxCustomers);
        this.GUI = GUI;
        this.suspend = rl.newCondition(); 
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.notify = notify;
        this.corridorHalls = corridorHalls;
        this.corridorHall_number = 0;
        this.suspended = false;
    }
    
    @Override
    public void call() {
        try {
            while (fifoEntranceHall.getCount() > 0) {

                            System.out.println("here");
                            if (corridorHalls[0].getFifoCorridorHall().hasSpace()) {
                                fifoEntranceHall.out();
                                TimeUnit.SECONDS.sleep(1);
                                continue;
                            }
                            else if (corridorHalls[1].getFifoCorridorHall().hasSpace()) {
                                setCorridorHall_number(1); 
                                fifoEntranceHall.out();
                                TimeUnit.SECONDS.sleep(1);
                                continue;
                            }
                            else if (corridorHalls[2].getFifoCorridorHall().hasSpace()) {
                                setCorridorHall_number(2);
                                fifoEntranceHall.out();
                                TimeUnit.SECONDS.sleep(1);
                            }
                            else return;
                        

                    
                
      
            }
        }
        catch(Exception e) {}    
    }
    
    @Override
    public int in(int customerId) {
        try {

                    notify.sendCustomerState("EntranceHall", customerId);
                    int position = this.selectPositionInGUI(customerId);
                    GUI.moveCustomer(customerId, new Integer[] {1, position});
                    int customerLeaving = fifoEntranceHall.in(customerId);
                    this.customersPosition[position] = -1;
                    //System.out.println("Customer " + customerLeaving + " corridor Hall: " + this.corridorHall_number);  
                    return this.corridorHall_number;
          

            
        }
        catch (Exception e) {}
        return this.corridorHall_number;
    }
   
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    }
    
    @Override
    public void suspend() {
        rl.lock();
        try {
            System.out.println("Control: "+this.suspended);
            this.suspended = true;
        } 
        finally {
          rl.unlock();
        }
    }
    
    
    public FIFO getFifoEntranceHall() {
        return this.fifoEntranceHall;
    }
    
    public void setCorridorHall_number(int number) {
        this.corridorHall_number = number;
    }
}
