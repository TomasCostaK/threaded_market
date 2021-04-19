/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActiveEntity;

import SAPaymentHall.IPaymentHall_Cashier;
import SAIdle.IIdle_Cashier;
import SAPaymentPoint.IPaymentPoint_Cashier;

/**
 *
 * @author tomascosta
 */
public class AECashier extends Thread { // id do customer
    // árae partilhada Idle
    private final IIdle_Cashier idle;
    private final IPaymentHall_Cashier paymentHall;
    private final IPaymentPoint_Cashier paymentPoint;
    
    public AECashier( IIdle_Cashier idle, IPaymentHall_Cashier paymentHall, IPaymentPoint_Cashier paymentPoint) {
        this.idle = idle;
        this.paymentHall = paymentHall;
        this.paymentPoint = paymentPoint;
    }

    
    @Override
    public void run() {
        while ( true ) {
            // thread avança para Idle
            idle.idle();
            // se simulação activa (não suspend, não stop, não end), thread avança para o outsideHall
            paymentHall.call();
            paymentPoint.process();
            // mais
        }
    }
    
    
}