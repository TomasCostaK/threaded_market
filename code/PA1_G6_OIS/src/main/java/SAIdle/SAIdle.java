/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAIdle;

import Communication.NotifyCustomerState;
import Main.OIS_GUI;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SAIdle implements IIdle_Customer,
                               IIdle_Manager,
                               IIdle_Control,
                               IIdle_Cashier {
    
    private final ReentrantLock rl = new ReentrantLock( true );
    private final Condition notStarted;
    private final Condition notNext;
    private final Condition notChoosen;
    private boolean customerIdle;
    private int nCustomers;
    private ArrayList<Integer> orderedCustomers = new ArrayList<Integer>();
    private int cto;
    private int previousCustomerId;
    private final OIS_GUI GUI;
    private boolean firstStopped;
    private final NotifyCustomerState notify;
    private boolean ended;
    private boolean notChoose;

    public SAIdle(OIS_GUI GUI, NotifyCustomerState notify) {
        this.notStarted = rl.newCondition(); 
        this.notChoosen = rl.newCondition(); 
        this.notNext = rl.newCondition();
        this.customerIdle = true;
        this.nCustomers = 10;
        this.cto = 0;
        this.previousCustomerId = -1;
        this.GUI = GUI;
        this.firstStopped = true;
        this.notify = notify;
        this.ended = false;
        this.notChoose = true;
    }
    
    @Override
    public void idle() {
        System.out.println("Manager idle.");
    }
    
    // idle Customer
    @Override
    public int idle( int customerId, int stopped ) {
        System.out.println("Customer " + customerId + " idle.");
        rl.lock();
        try {
            if(stopped==1) {
                this.customerIdle = true;
                this.notify.sendCustomerState("Idle", customerId);
                if(this.firstStopped) {
                    this.GUI.cleanCustomers();
                    this.firstStopped = false;
                }
            }
            while (this.customerIdle == true) {
                this.notStarted.await();
                if (this.ended) return 1;
            }  
           
            if (customerId > this.nCustomers) {
                while(notChoose) this.notChoosen.await();
                if (this.ended) return 1;
                //System.out.println("Customer " + customerId + " entering OutsideHall.");
                //orderedCustomers.set(customerId, customerId);
                //System.out.println("Customers Array: " + orderedCustomers);
            }
            else {
                while (customerId != this.previousCustomerId + 1) {
                    this.notNext.await();
                }
                this.previousCustomerId++;
                this.notNext.signalAll();
                
               
            }
            
        }
        catch(InterruptedException ex)
        {
          System.err.println("ERROR: Customer " + customerId + " was unable to enter Idle!");
        }
        finally {   
          try{
                Thread.sleep(this.randomTimeout());
           } catch (InterruptedException ex) {}
           rl.unlock();
        }
        return this.cto;
    }
        
    @Override
    public void start( int nCustomers, int cto ) {
        setNCustomers(nCustomers);
        rl.lock();
        try {
            TimeUnit.SECONDS.sleep(5); // só para simular o user a dar start
            System.out.println("Start simulation...");
            this.customerIdle = false;
            this.cto = cto;
            this.notStarted.signalAll();
        } 
        catch ( InterruptedException ex ) {}
        finally {
          rl.unlock();
        }
 
    }
    @Override
    public void end() {
        rl.lock();
        try {
            this.customerIdle = false;
            this.notStarted.signalAll();
            this.notChoose = false;
            this.notChoosen.signalAll();
            this.ended = true;
        }
        finally {
          rl.unlock();
        }     
    }
    
    
    private long randomTimeout(){
        return new Random().nextInt(101);
    } 
    
    
    public void setNCustomers(int nCustomers) {
        this.nCustomers = nCustomers;
    }
    
    @Override
    public void setFirstStopped(boolean firstStopped) {
        this.firstStopped = firstStopped;
    }
    
    @Override
    public void setPreviousCustomerId() {
        this.previousCustomerId = -1;
    }
       
}






 