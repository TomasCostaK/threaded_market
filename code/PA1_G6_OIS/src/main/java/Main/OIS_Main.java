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
import ManagerHall.ManagerHall;
import SAIdle.*;
import SAOutsideHall.*;
import SAEntranceHall.*;
import SACorridorHall.*;
import SACorridor.*;
import SAPaymentHall.*;
import SAPaymentPoint.*;

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
        final SAIdle idle = new SAIdle(GUI, notify);
        
        final SACorridor[] corridors = new SACorridor[N_CORRIDOR];
        
        final SACorridorHall[] corridorHalls = new SACorridorHall[N_CORRIDOR];
        
        final SAPaymentPoint paymentPoint = new SAPaymentPoint (SIZE_PAYMENT_BOX, GUI, notify , 9);
        final SAPaymentHall paymentHall = new SAPaymentHall ( SIZE_PAYMENT_HALL, GUI, notify, 8 ,paymentPoint );
        
        // create N_CORRIDORS Halls and N Corridors, we get ordered corridor halls, corresponding to the given corridor
        for(int i=0; i<N_CORRIDOR; i++){
                        
            SACorridor corridor = new SACorridor( SIZE_CORRIDOR, GUI, notify, 5+i, paymentHall);
            corridors[i] = corridor;
            
            SACorridorHall corridor_hall = new SACorridorHall( SIZE_CORRIDOR_HALL, GUI, notify,2+i, corridor);
            corridorHalls[i] = corridor_hall;

        }
        
        
        final SAEntranceHall entranceHall = new SAEntranceHall ( SIZE_ENTRANCE_HALL, GUI, notify, corridorHalls );
        final SAOutsideHall outsideHall =  new SAOutsideHall( MAX_CUSTOMERS, GUI, notify, entranceHall );
        
        
        final ManagerHall managerHall = new ManagerHall((IOutsideHall_Manager) outsideHall, (IEntranceHall_Manager) entranceHall  );
        


        final AECustomer[] aeCustomer = new AECustomer[ MAX_CUSTOMERS ];
        final AEControl control = new AEControl( (IIdle_Control) idle, (IOutsideHall_Control) outsideHall, (IEntranceHall_Control) entranceHall, (ICorridorHall_Control[]) corridorHalls, (ICorridor_Control[]) corridors, (IPaymentPoint_Control) paymentPoint);
        final AEManager manager = new AEManager(( IIdle_Manager) idle, (IOutsideHall_Manager) outsideHall, (IEntranceHall_Manager) entranceHall, (ManagerHall) managerHall);
        final AECashier cashier = new AECashier((IIdle_Cashier) idle, (IPaymentHall_Cashier) paymentHall, (IPaymentPoint_Cashier) paymentPoint);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI.setVisible(true);
            }
        });
        
        control.start();
        manager.start();
        cashier.start();
        for ( int i = 0; i < MAX_CUSTOMERS; i++ ) {
            aeCustomer[ i ] = new AECustomer( i,
                                              (IIdle_Customer) idle,
                                              (IOutsideHall_Customer) outsideHall, 
                                              (IEntranceHall_Customer) entranceHall,
                                              (ICorridorHall_Customer[]) corridorHalls,
                                              (ICorridor_Customer[]) corridors,
                                              (IPaymentHall_Customer) paymentHall,
                                              (IPaymentPoint_Customer) paymentPoint,
                                              notify, GUI
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
