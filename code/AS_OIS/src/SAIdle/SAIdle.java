/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAIdle;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author omp
 */
public class SAIdle implements IIdle_Customer,
                               IIdle_Manager,
                               IIdle_Control {
    
    private final ReentrantLock rl = new ReentrantLock( true );
    private final Condition notStarted;
    private boolean customerIdle;

    public SAIdle() {
        this.notStarted = rl.newCondition(); 
        this.customerIdle = true; 
    }
    
    @Override
    public void idle() {
        System.out.println("Manager idle.");
    }
    
    // idle Customer
    @Override
    public void idle( int customerId ) {
        rl.lock();
        try {
            while (customerIdle == true) {
                notStarted.await();
            }  
            System.out.println("Customer " + customerId + " entering OutsideHall.");
        }
        catch(InterruptedException ex)
        {
          System.out.println( " interrupted");
        }
        finally {   
          rl.unlock();
        }
    }
        
    @Override
    public void start( int nCustomers ) {
        rl.lock();
        try {
            TimeUnit.SECONDS.sleep(10); // só para simular o user a dar start
            System.out.println("Start simulation...");
            customerIdle = false;
            notStarted.signal();
        } 
        catch ( Exception ex ) {}
        finally {
          rl.unlock();
        }
 
    }
    @Override
    public void end() {   
    }
   
}






 