/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SACorridor;
import Communication.NotifyCustomerState;

import FIFO.FIFO;
import FIFO.Queue;
import Main.OIS_GUI;

/**
 *
 * @author omp
 */
public class SACorridor implements ICorridor_Customer,
                                       ICorridor_Control {
    
    final Queue fifoCorridor;
    private int totalCustomers;
    private final OIS_GUI GUI;
    private final int customersPosition[];
    private final NotifyCustomerState notify;
    private final int id;

    public SACorridor( int maxCustomers, OIS_GUI GUI, NotifyCustomerState notify, int id ) {
        this.fifoCorridor = new Queue<Integer>(maxCustomers);
        this.GUI = GUI;
        this.totalCustomers = maxCustomers;
        this.customersPosition = new int[totalCustomers];
        for(int i = 0; i < totalCustomers; i ++){
            this.customersPosition[i] = -1;
        }
        this.id = id;
        this.notify = notify;
    }
    

    @Override
    public void in(int customerId) {
        notify.sendCustomerState("Corridor", customerId);
        int position = this.selectPositionInGUI(customerId);
        GUI.moveCustomer(customerId, new Integer[] {id, position});
        fifoCorridor.in(customerId);
    }
    
    @Override
    public void out() {
        // While there is space in the corridor queue, go for it
        while (true) {
            fifoCorridor.out();
        }
    }

    // Check if there is no one in front of the customer, so they dont advance to the same tile
    @Override
    public void checkTreadmill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Blocking condition, keeps moving forward until checkTreadmill returns that there is someone in front
    @Override
    public void forward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int selectPositionInGUI(int customerId){
        int position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        while(customersPosition[position] != -1) position = (int) Math.round((Math.random() * (totalCustomers - 1)));
       
        customersPosition[position] = customerId;
        return position;
    } 

    public Queue getFifoCorridor() {
        return this.fifoCorridor;
    }

}
