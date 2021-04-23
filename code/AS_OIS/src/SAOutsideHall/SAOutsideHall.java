/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAOutsideHall;

import Communication.NotifyCustomerState;
import FIFO.FIFO;
import Main.OIS_GUI;
import SAEntranceHall.SAEntranceHall;
import java.util.Random;
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
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;
    private int previousCustomerId;
    private boolean suspended;
    

    public SAOutsideHall( int totalCustomers, OIS_GUI GUI, NotifyCustomerState notify, SAEntranceHall entranceHall) {
        this.totalCustomers = totalCustomers;
        this.GUI = GUI;
        this.fifoOutsideHall = new FIFO(totalCustomers); 
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.notify = notify;
        this.entranceHall = entranceHall;
        this.previousCustomerId = -1;
        this.suspended = false;
    } 

    @Override
    public void in(int customerId) {
        if(!this.suspended) {
            this.previousCustomerId++;
            notify.sendCustomerState("OutsideHall", customerId);
            int position = this.selectPositionInGUI(customerId);
            GUI.moveCustomer(customerId, new Integer[] {0, position});   
            fifoOutsideHall.in(customerId);
        }   
        else {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
    
    @Override
    public void call() {
        if (!this.suspended) {
            try {
                while (entranceHall.getFifoEntranceHall().getCount() < entranceHall.getFifoEntranceHall().getMaxCustomers() && fifoOutsideHall.getCount() > 0) {
                    fifoOutsideHall.out();
                    Thread.sleep(1000);
                }
            }
            catch(Exception e) {}    }
        else{
            try {
                Thread.sleep(100000);
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
    
    private long randomTimeout(){
        return new Random().nextInt(101);
    }
    
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    }
    
    public FIFO getFifoOutsideHall() {
        return this.fifoOutsideHall;
    }
    
    @Override
    public void suspend() {
        rl.lock();
        try {
            this.suspended = true;
        } 
        finally {
          rl.unlock();
        }
    }
}
