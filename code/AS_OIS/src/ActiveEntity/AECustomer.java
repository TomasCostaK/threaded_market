package ActiveEntity;


import SAIdle.IIdle_Customer;
import SAOutsideHall.IOutsideHall_Customer;
import SAEntranceHall.IEntranceHall_Customer;
import SACorridorHall.ICorridorHall_Customer;
import SACorridor.ICorridor_Customer;
import SAPaymentHall.IPaymentHall_Customer;
import SAPaymentPoint.IPaymentPoint_Customer;
import java.util.concurrent.TimeUnit;
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
    private final ICorridorHall_Customer corridorHall;
    private final ICorridor_Customer corridor;
    private final IPaymentHall_Customer paymentHall;
    private final IPaymentPoint_Customer paymentPoint;
    
    public AECustomer( int customerId, IIdle_Customer idle, IOutsideHall_Customer outsideHall, IEntranceHall_Customer entranceHall, ICorridorHall_Customer corridorHall, ICorridor_Customer corridor, IPaymentHall_Customer paymentHall, IPaymentPoint_Customer paymentPoint) {
        this.customerId = customerId;
        this.idle = idle;
        this.outsideHall = outsideHall;
        this.entranceHall = entranceHall;
        this.corridorHall = corridorHall;
        this.corridor = corridor;
        this.paymentHall = paymentHall;
        this.paymentPoint = paymentPoint;
    }
    
    @Override
    public void run() {
        while ( true ) {
            try{
            // thread avança para Idle
                idle.idle(customerId );
                // se simulação activa (não suspend, não stop, não end), thread avança para o outsideHall
                outsideHall.in( customerId );
                TimeUnit.SECONDS.sleep(5); 
                entranceHall.in( customerId );
                TimeUnit.SECONDS.sleep(5);
                corridorHall.in( customerId );
                TimeUnit.SECONDS.sleep(5);
                corridor.in(customerId);
                paymentHall.in(customerId);
                paymentPoint.in(customerId);
            }
            catch ( Exception ex ) {}
        }
    }
}
