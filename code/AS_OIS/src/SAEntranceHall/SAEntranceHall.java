/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAEntranceHall;

import FIFO.FIFO;

/**
 *
 * @author omp
 */
public class SAEntranceHall implements IEntranceHall_Customer,
                                       IEntranceHall_Manager,
                                       IEntranceHall_Control {
    
    final FIFO fifoEntranceHall;

    public SAEntranceHall( int maxCustomers ) {
        fifoEntranceHall = new FIFO(maxCustomers);
    } 
    
    @Override
    public void call() {
        fifoEntranceHall.out();
    }

    @Override
    public void in(int customerId) {
        System.out.println("Customer " + customerId + " waiting to enter CorridorHall");
        int CostumerLeaving = fifoEntranceHall.in(customerId);
        System.out.println("Customer " + customerId + " entering CorridorHall");
    }
    
}
