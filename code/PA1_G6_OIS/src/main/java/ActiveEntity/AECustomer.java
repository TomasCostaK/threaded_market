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

public class AECustomer extends Thread { 
    
    private final int customerId;

    private final IIdle_Customer idle;
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
        this.notify = notify;
        this.GUI = GUI;
    }
    
    @Override
    public void run() {
         
            try{  
                while(true) {
            // thread avança para Idle
                    this.idle.setFirstStopped(true);
                    this.idle.setPreviousCustomerId();
                    int result = this.idle.idle(this.customerId, this.stopped);
                    if (result==1) { // END
                        this.GUI.cleanCustomers();
                        this.notify.sendCustomerState("Terminated", customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    else this.cto = result;
                    this.outsideHall.setStopped(false);
                    this.stopped = outsideHall.in( this.customerId );
                    if(this.stopped==1) continue;  // STOP
                    else if (this.stopped==2) {  // END
                        this.GUI.cleanCustomers();
                        this.notify.sendCustomerState("Terminated",this.customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    this.entranceHall.setStopped(false);
                    int[] results = entranceHall.in( this.customerId );
                    this.corridorNumber = results[0]; 
                    this.stopped = results[1];
                    if(this.stopped==1) continue; // STOP
                    else if (this.stopped==2) {  // END
                        this.GUI.cleanCustomers();
                        this.notify.sendCustomerState("Terminated", this.customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    this.corridorHalls[this.corridorNumber].setStopped(false);
                    this.corridorHalls[this.corridorNumber].in(this.customerId);
                    Thread.sleep(2000);
                    this.stopped = this.corridorHalls[this.corridorNumber].out(this.customerId);  
                    if(this.stopped==1) continue; // STOP
                    else if (this.stopped==2) {  // END
                        this.GUI.cleanCustomers();
                        this.notify.sendCustomerState("Terminated", customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    this.stopped = this.corridors[this.corridorNumber].in(this.customerId, this.cto);
                    if(this.stopped==1) continue; // STOP
                    else if (this.stopped==2) {  // END
                        this.GUI.cleanCustomers();
                        this.notify.sendCustomerState("Terminated", this.customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    
                    Thread.sleep(1000);
                    this.paymentPoint.setStopped(false);
                    this.stopped = this.paymentPoint.in(this.customerId);
                    if(this.stopped==1) continue; // STOP
                    else if (this.stopped==2) {  // END
                        this.GUI.cleanCustomers();
                        this.notify.sendCustomerState("Terminated", this.customerId);
                        Thread.currentThread().interrupt();
                        break;
                    }
                    Thread.sleep(1000000);
                }             
            }
            catch ( InterruptedException ex ) {}
        
    }

}

