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
import java.util.concurrent.locks.ReentrantLock;

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
    private boolean stopped;
    private boolean ended;
    

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
        this.stopped = false;
        this.ended = false;
    } 

    @Override
    public int in(int customerId) {
        this.previousCustomerId++;
        this.notify.sendCustomerState("OutsideHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        this.GUI.moveCustomer(customerId, new Integer[] {0, position});   
        this.fifoOutsideHall.in(customerId);
        if (this.stopped) {
            return 1;
        }
        else if(this.ended) return 2;
        return 0;
    }
    
    
    @Override
    public void call() {
        while (this.entranceHall.getFifoEntranceHall().getCount() < this.entranceHall.getFifoEntranceHall().getMaxCustomers() && this.fifoOutsideHall.getCount() > 0) {
            while(true)
                if (!this.suspended) {
                    this.fifoOutsideHall.out();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {}
                    break;
                }
                else{
                    try {
                        if (this.ended) {
                            this.fifoOutsideHall.out();
                            if (this.fifoOutsideHall.getCount() == 0) return;
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {}
                } 
        }
    }
    
    
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        while(this.customersPosition[position] != -1) position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        this.customersPosition[position] = customerId;
        return position;
    }
    
    public FIFO getFifoOutsideHall() {
        return this.fifoOutsideHall;
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
