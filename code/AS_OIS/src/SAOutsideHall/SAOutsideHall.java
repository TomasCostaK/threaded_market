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
    private final Condition customerNotLeaved;
    private boolean managerWaiting;
    private boolean firstEntered;
    private int nCustomers;

    public SAOutsideHall( int maxCustomers ) {
        fifoOutsideHall = new FIFO(maxCustomers);
        this.notCalled = rl.newCondition(); 
        this.customerWaiting = true; 
        this.customerNotLeaved = rl.newCondition(); 
        this.managerWaiting = true; 
        this.firstEntered = false;
        this.nCustomers = 0;
    } 

    @Override
    public void in(int customerId) {
        rl.lock();
        try {
            if (nCustomers == 0) {
                firstEntered = true;
            }
            System.out.println("Customer " + customerId + " in OutsideHall.");
            int customerLeaving = fifoOutsideHall.in(customerId);
            System.out.println("Customer " + customerLeaving + " leaving OutsideHall.");
            while (customerWaiting == true) {
                notCalled.await();
            }  
            managerWaiting = false;
            customerNotLeaved.signal();
            

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
        System.out.println("Manager in Outside Hall");
        rl.lock();
        try {
            while(true){
                if(firstEntered==true) fifoOutsideHall.out();
                while (managerWaiting == true)
                    customerNotLeaved.await();
                customerWaiting = false;
                notCalled.signal();
                fifoOutsideHall.out();
                }
        }
        catch(Exception ex)
        {
          System.out.println( " interrupted");
        }
        finally {
          rl.unlock();
        }       
    }
}
