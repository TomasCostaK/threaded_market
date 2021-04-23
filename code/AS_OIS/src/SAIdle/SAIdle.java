/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAIdle;

import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author omp
 */
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

    public SAIdle() {
        this.notStarted = rl.newCondition(); 
        this.notChoosen = rl.newCondition(); 
        this.notNext = rl.newCondition();
        this.customerIdle = true;
        this.nCustomers = 10;
        this.cto = 0;
        this.previousCustomerId = -1;
    }
    
    @Override
    public void idle() {
        //System.out.println("Manager idle.");
    }
    
    // idle Customer
    @Override
    public int idle( int customerId ) {
        System.out.println("Customer " + customerId + " idle.");
        rl.lock();
        try {
            while (customerIdle == true) {
                notStarted.await();
            }  
            if (customerId > this.nCustomers) {
                notChoosen.await();
                //System.out.println("Customer " + customerId + " entering OutsideHall.");
                //orderedCustomers.set(customerId, customerId);
                //System.out.println("Customers Array: " + orderedCustomers);
            }
            else {
                while (customerId != this.previousCustomerId + 1) {
                    notNext.await();
                }
                this.previousCustomerId++;
                notNext.signalAll();
                
               
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
            customerIdle = false;
            this.cto = cto;
            notStarted.signalAll();
        } 
        catch ( InterruptedException ex ) {}
        finally {
          rl.unlock();
        }
 
    }
    @Override
    public void end() { 
        System.out.println("End Simulation");
        
    }
    
    
    private long randomTimeout(){
        return new Random().nextInt(101);
    } 
    
    
    public void setNCustomers(int nCustomers) {
        this.nCustomers = nCustomers;
    }
    
   
}






 