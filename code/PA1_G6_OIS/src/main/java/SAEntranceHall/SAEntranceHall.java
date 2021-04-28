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
import java.util.concurrent.locks.ReentrantLock;

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
    private boolean stopped;
    private boolean ended;

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
        this.corridorHall_number = 0;
        this.suspended = false;
        this.stopped = false;
        this.ended = false;
    }
    
    @Override
    public void call() {
        try {
            while (this.fifoEntranceHall.getCount() > 0) {
                while (true) {
                    if (!this.suspended) {
                        if (this.corridorHalls[0].getFifoCorridorHall().hasSpace()) {
                            this.fifoEntranceHall.out();
                            TimeUnit.SECONDS.sleep(1);
                            break;
                        }
                        else if (this.corridorHalls[1].getFifoCorridorHall().hasSpace()) {
                            setCorridorHall_number(1); 
                            this.fifoEntranceHall.out();
                            TimeUnit.SECONDS.sleep(1);
                            break;
                        }
                        else if (this.corridorHalls[2].getFifoCorridorHall().hasSpace()) {
                            setCorridorHall_number(2);
                            this.fifoEntranceHall.out();
                            TimeUnit.SECONDS.sleep(1);
                            break;
                        }
                        else return;
                    }
                    else {
                        if (this.ended) this.fifoEntranceHall.out();
                        if (this.fifoEntranceHall.getCount() == 0) return;
                        TimeUnit.SECONDS.sleep(1);
                        
                    }
                }
            }
        }
        catch(Exception e) {}    
    }
    
    @Override
    public int[] in(int customerId) {
        this.notify.sendCustomerState("EntranceHall", customerId);
        int position = this.selectPositionInGUI(customerId);
        this.GUI.moveCustomer(customerId, new Integer[] {1, position});
        this.fifoEntranceHall.in(customerId);
        this.customersPosition[position] = -1;
        if (this.stopped)  {
            int[] result = {this.corridorHall_number, 1};
            return result;
        } 
        else if(this.ended) {
            int[] result = {this.corridorHall_number, 2};
            return result;
        }
        int[] result = {this.corridorHall_number, 0};
        return result;
        //System.out.println("Customer " + customerLeaving + " corridor Hall: " + this.corridorHall_number);  
    }
   
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        while(this.customersPosition[position] != -1) position = (int) Math.round((Math.random() * (this.totalCustomers - 1)));
       
        this.customersPosition[position] = customerId;
        return position;
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
        
    public FIFO getFifoEntranceHall() {
        return this.fifoEntranceHall;
    }
    
    public void setCorridorHall_number(int number) {
        this.corridorHall_number = number;
    }
    
    @Override
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
