/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ActiveEntity.AEControl;
import ActiveEntity.AECustomer;
import ActiveEntity.AEManager;
import Communication.NotifyCustomerState;
import SAEntranceHall.IEntranceHall_Customer;
import SAEntranceHall.IEntranceHall_Manager;
import SAEntranceHall.SAEntranceHall;
import SAIdle.IIdle_Control;
import SAIdle.IIdle_Customer;
import SAIdle.IIdle_Manager;
import SAIdle.SAIdle;
import SAOutsideHall.IOutsideHall_Customer;
import SAOutsideHall.IOutsideHall_Manager;
import SAOutsideHall.SAOutsideHall;
/**
 *
 * @author alina
 */
public class OIS_Main {
    
     public static void main(String args[]) {
        final int MAX_CUSTOMERS =  99;
        final int N_CORRIDOR_HALL = 3;
        final int N_CORRIDOR = 3;
        final int SIZE_ENTRANCE_HALL = 2;
        final int SIZE_CORRIDOR_HALL = 3;
        // ....

        final NotifyCustomerState notify = new NotifyCustomerState();
        final OIS_GUI GUI = new OIS_GUI();
        final SAIdle idle = new SAIdle();
        final SAOutsideHall outsideHall =  new SAOutsideHall( MAX_CUSTOMERS, GUI, notify );
        final SAEntranceHall entranceHall = new SAEntranceHall ( SIZE_ENTRANCE_HALL, GUI );

        
        final AECustomer[] aeCustomer = new AECustomer[ MAX_CUSTOMERS ];
        final AEControl control = new AEControl( (IIdle_Control) idle);
        final AEManager manager = new AEManager(( IIdle_Manager) idle, (IOutsideHall_Manager) outsideHall, (IEntranceHall_Manager) entranceHall  );
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI.setVisible(true);
            }
        });
        
        control.start();
        manager.start();
        for ( int i = 0; i < MAX_CUSTOMERS; i++ ) {
            aeCustomer[ i ] = new AECustomer( i,
                                              (IIdle_Customer) idle,
                                              (IOutsideHall_Customer) outsideHall, (IEntranceHall_Customer) entranceHall );
            aeCustomer[ i ].start();
        }
       
        
        try {
            for ( int i = 0; i < MAX_CUSTOMERS; i++ )
                aeCustomer[ i ].join();
            manager.join();
            control.join();
        } catch ( Exception ex ) {}   

        
             
    }
}
