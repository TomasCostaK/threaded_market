package ActiveEntity;


import Communication.NotifyCustomerState;
import Main.OIS_GUI;
import SAIdle.IIdle_Customer;
import SAOutsideHall.IOutsideHall_Customer;
import SAEntranceHall.IEntranceHall_Customer;
import SACorridorHall.ICorridorHall_Customer;
import SACorridor.ICorridor_Customer;
import SAPaymentHall.IPaymentHall_Customer;
import SAPaymentPoint.IPaymentPoint_Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Não pretende implementar a entidade activa Customer. Serve apenas para dar pistas como o
 * Thread Custumer deve recorrer a àreas partilhadas para gerir as transições de estado.
 * @author alina
 */
public class AECustomer extends Thread { 
    
    // id do customer
    private final int customerId;
    
    // árae partilhada Idle
    private final IIdle_Customer idle;
    // área partilhada OutsideHall
    private final IOutsideHall_Customer outsideHall;
    private final IEntranceHall_Customer entranceHall;
    private final ICorridorHall_Customer[] corridorHalls;
    private final ICorridor_Customer[] corridors;
    private final IPaymentHall_Customer paymentHall;
    private final IPaymentPoint_Customer paymentPoint;
    private int corridorNumber;
    private final NotifyCustomerState notify;
    private int cto;
    private int stopped;
    private boolean firstStopped;
    private final OIS_GUI GUI;
    
    public AECustomer( int customerId, IIdle_Customer idle, IOutsideHall_Customer outsideHall, IEntranceHall_Customer entranceHall, ICorridorHall_Customer[] corridorHalls, ICorridor_Customer[] corridors, IPaymentHall_Customer paymentHall, IPaymentPoint_Customer paymentPoint, NotifyCustomerState notify, OIS_GUI GUI) {
        this.customerId = customerId;
        this.idle = idle;
        this.outsideHall = outsideHall;
        this.entranceHall = entranceHall;
        this.corridorHalls = corridorHalls;
        this.corridors = corridors;
        this.paymentHall = paymentHall;
        this.paymentPoint = paymentPoint;
        this.corridorNumber = 0;
        this.cto = 0;
        this.stopped = 0;
        this.firstStopped = true;
        this.notify = notify;
        this.GUI = GUI;
    }
    
    @Override
    public void run() {
         
            try{  
                while(true) {
            // thread avança para Idle
                    idle.setFirstStopped(true);
                    idle.setPreviousCustomerId();
                    int result = idle.idle(customerId, this.stopped);
                    if (result==1) { // END
                        GUI.cleanCustomers();
                        notify.sendCustomerState("Terminated", customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    else this.cto = result;
                    outsideHall.setStopped(false);
                    this.stopped = outsideHall.in( customerId );
                    if(this.stopped==1) continue;  // STOP
                    else if (this.stopped==2) {  // END
                        GUI.cleanCustomers();
                        notify.sendCustomerState("Terminated", customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    entranceHall.setStopped(false);
                    int[] results = entranceHall.in( customerId );
                    this.corridorNumber = results[0]; 
                    this.stopped = results[1];
                    if(this.stopped==1) continue; // STOP
                    else if (this.stopped==2) {  // END
                        GUI.cleanCustomers();
                        notify.sendCustomerState("Terminated", customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    corridorHalls[this.corridorNumber].setStopped(false);
                    corridorHalls[this.corridorNumber].in(customerId);
                    Thread.sleep(2000);
                    this.stopped = corridorHalls[this.corridorNumber].out(customerId);  
                    if(this.stopped==1) continue; // STOP
                    else if (this.stopped==2) {  // END
                        GUI.cleanCustomers();
                        notify.sendCustomerState("Terminated", customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    corridors[this.corridorNumber].setStopped(false);
                    this.stopped = corridors[this.corridorNumber].in(customerId, cto);
                    if(this.stopped==1) continue; // STOP
                    else if (this.stopped==2) {  // END
                        GUI.cleanCustomers();
                        notify.sendCustomerState("Terminated", customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    paymentHall.in(customerId);
                    paymentPoint.in(customerId);
                    
                    Thread.sleep(1000000);
                }             
            }
            catch ( InterruptedException ex ) {}
        
    }

}

