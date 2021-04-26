package ActiveEntity;


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
    private int cto;
    
    public AECustomer( int customerId, IIdle_Customer idle, IOutsideHall_Customer outsideHall, IEntranceHall_Customer entranceHall, ICorridorHall_Customer[] corridorHalls, ICorridor_Customer[] corridors, IPaymentHall_Customer paymentHall, IPaymentPoint_Customer paymentPoint) {
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
    }
    
    @Override
    public void run() {
         
            try{
            // thread avança para Idle
                cto = idle.idle(customerId );
                // se simulação activa (não suspend, não stop, não end), thread avança para o outsideHall
                outsideHall.in( customerId );
                this.corridorNumber = entranceHall.in( customerId );
                corridorHalls[this.corridorNumber].in(customerId);
                Thread.sleep(2000);
                corridorHalls[this.corridorNumber].out(customerId);         
                corridors[this.corridorNumber].in(customerId, cto);
                // This is paused, since paymentHall is implemented differently
                paymentPoint.in(customerId);
                
                // Finished trip
                // idle.idle(customerId );
            }
            catch ( Exception ex ) {}
        
    }

}
