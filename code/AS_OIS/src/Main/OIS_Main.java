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
import SAIdle.*;
import SAOutsideHall.*;
import SAEntranceHall.*;
import SACorridorHall.*;
/**
 *
 * @author alina
 */
public class OIS_Main {
    
     public static void main(String args[]) {
        final int MAX_CUSTOMERS =  99;
        final int N_CORRIDOR_HALL = 3;
        final int N_CORRIDOR = 3;
        final int SIZE_ENTRANCE_HALL = 6;
        final int SIZE_CORRIDOR_HALL = 3;
        // ....

        final NotifyCustomerState notify = new NotifyCustomerState();
        final OIS_GUI GUI = new OIS_GUI();
        final SAIdle idle = new SAIdle();
        final SAOutsideHall outsideHall =  new SAOutsideHall( MAX_CUSTOMERS, GUI, notify );
        final SAEntranceHall entranceHall = new SAEntranceHall ( SIZE_ENTRANCE_HALL, GUI, notify );
        final SACorridorHall[] corridorHalls = new SACorridorHall[N_CORRIDOR];
        
        // create N_CORRIDORS, we get ordered corridor halls, corresponding to the given corridor
        for(int i=0; i<N_CORRIDOR; i++){
            SACorridorHall corridor = new SACorridorHall( SIZE_CORRIDOR_HALL, GUI, notify);
            corridorHalls[i] = corridor;
        }

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
