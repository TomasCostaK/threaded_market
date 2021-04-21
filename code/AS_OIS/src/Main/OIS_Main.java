/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ActiveEntity.AEControl;
import ActiveEntity.AECustomer;
import ActiveEntity.AEManager;
import ActiveEntity.AECashier;
import Communication.NotifyCustomerState;
import SAIdle.*;
import SAOutsideHall.*;
import SAEntranceHall.*;
import SACorridorHall.*;
import SACorridor.*;
import SAPaymentHall.*;
import SAPaymentPoint.*;

/**
 *
 * @author alina
 */
public class OIS_Main {
    
     public static void main(String args[]) {
        final int MAX_CUSTOMERS =  99;
        final int N_CORRIDOR = 3;
        final int SIZE_ENTRANCE_HALL = 6;
        final int SIZE_CORRIDOR_HALL = 3;
        final int SIZE_CORRIDOR = 2;
        final int SIZE_PAYMENT_HALL = 2;
        final int SIZE_PAYMENT_BOX = 1;

        final NotifyCustomerState notify = new NotifyCustomerState();
        final OIS_GUI GUI = new OIS_GUI();
        final SAIdle idle = new SAIdle();
        
        final SACorridor[] corridors = new SACorridor[N_CORRIDOR];
        
        final SACorridorHall[] corridorHalls = new SACorridorHall[N_CORRIDOR];
        
        // create N_CORRIDORS Halls and N Corridors, we get ordered corridor halls, corresponding to the given corridor
        for(int i=0; i<N_CORRIDOR; i++){
                        
            SACorridor corridor = new SACorridor( SIZE_CORRIDOR, GUI, notify, 5+i);
            corridors[i] = corridor;
            
            SACorridorHall corridor_hall = new SACorridorHall( SIZE_CORRIDOR_HALL, GUI, notify,2+i, corridor);
            corridorHalls[i] = corridor_hall;

        }
        
        
        final SAEntranceHall entranceHall = new SAEntranceHall ( SIZE_ENTRANCE_HALL, GUI, notify, corridorHalls );
        final SAOutsideHall outsideHall =  new SAOutsideHall( MAX_CUSTOMERS, GUI, notify, entranceHall );
        

        final SAPaymentHall paymentHall = new SAPaymentHall ( SIZE_PAYMENT_HALL, GUI, notify );
        final SAPaymentPoint paymentPoint = new SAPaymentPoint (SIZE_PAYMENT_BOX, GUI, notify);
        


        final AECustomer[] aeCustomer = new AECustomer[ MAX_CUSTOMERS ];
        final AEControl control = new AEControl( (IIdle_Control) idle);
        final AEManager manager = new AEManager(( IIdle_Manager) idle, (IOutsideHall_Manager) outsideHall, (IEntranceHall_Manager) entranceHall  );
        final AECashier cashier = new AECashier((IIdle_Cashier) idle, (IPaymentHall_Cashier) paymentHall, (IPaymentPoint_Cashier) paymentPoint);
        
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
                                              (IOutsideHall_Customer) outsideHall, 
                                              (IEntranceHall_Customer) entranceHall,
                                              (ICorridorHall_Customer) corridorHalls[0],
                                              (ICorridor_Customer) corridors[0],
                                              (IPaymentHall_Customer) paymentHall,
                                              (IPaymentPoint_Customer) paymentPoint
                );
            aeCustomer[ i ].start();
        }
       
        
        try {
            for ( int i = 0; i < MAX_CUSTOMERS; i++ )
                aeCustomer[ i ].join();
            manager.join();
            control.join();
            cashier.join();
        } catch ( Exception ex ) {}   

        
             
    }
}
