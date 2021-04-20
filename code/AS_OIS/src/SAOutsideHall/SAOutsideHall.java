/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAOutsideHall;

import ActiveEntity.AEControl;
import Communication.NotifyCustomerState;
import FIFO.FIFO;
import Main.OIS_GUI;
import SAEntranceHall.SAEntranceHall;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author omp 
 */
public class SAOutsideHall implements IOutsideHall_Manager,
                                      IOutsideHall_Customer,
                                      IOutsideHall_Control {
    
    final FIFO fifoOutsideHall;
    private final SAEntranceHall entranceHall;
    private final ReentrantLock rl = new ReentrantLock( true );
    private final Condition customerNotIn;
    private boolean managerWaiting;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;
    

    public SAOutsideHall( int totalCustomers, OIS_GUI GUI, NotifyCustomerState notify, SAEntranceHall entranceHall) {
        this.totalCustomers = totalCustomers;
        this.GUI = GUI;
        this.fifoOutsideHall = new FIFO(totalCustomers); 
        this.customerNotIn = rl.newCondition(); 
        this.managerWaiting = true; 
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.notify = notify;
        this.entranceHall = entranceHall;
    } 

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("OutsideHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {0, position});
        int customerLeaving = fifoOutsideHall.in(customerId);
        //System.out.println("Customer " + customerLeaving + " leaving OutsideHall.");    
    }
    
    
    @Override
    public void call() {
        try {
            while (entranceHall.getFifoEntranceHall().getCount() < entranceHall.getFifoEntranceHall().getMaxCustomers() - 1) {
                //System.out.println("FIFO Outside: " + fifoOutsideHall.getCount());
                fifoOutsideHall.out();
                Thread.sleep(2000);
            }
        }
        catch(Exception e) {}    }
    
    
    private long randomTimeout(){
        return new Random().nextInt(101);
    }
    
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    }
    
}
