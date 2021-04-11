/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAOutsideHall;

import FIFO.FIFO;
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
    private final ReentrantLock rl = new ReentrantLock( true );
    private final Condition notCalled;
    private boolean customerWaiting;

    public SAOutsideHall( int maxCustomers ) {
        fifoOutsideHall = new FIFO(maxCustomers);
        this.notCalled = rl.newCondition(); 
        this.customerWaiting = true; 
    } 

    @Override
    public void in(int customerId) {
        rl.lock();
        try {
            while (customerWaiting == true) {
                notCalled.await();
            }  
            System.out.println("Customer " + customerId + " entering EntranceHall");
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
    public void call() {
        fifoOutsideHall.out();
    }
}
