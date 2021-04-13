/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActiveEntity;

import SAEntranceHall.IEntranceHall_Manager;
import SAIdle.IIdle_Manager;
import SAOutsideHall.IOutsideHall_Manager;

/**
 *
 * @author alina
 */
public class AEManager extends Thread { // id do customer
    // árae partilhada Idle
    private final IIdle_Manager idle;
    // área partilhada OutsideHall
    private final IOutsideHall_Manager outsideHall;
    private final IEntranceHall_Manager entranceHall;
    
    public AEManager(IIdle_Manager idle, IOutsideHall_Manager outsideHall, IEntranceHall_Manager entranceHall  /* mais args */ ) {
        this.idle = idle;
        this.outsideHall = outsideHall;
        this.entranceHall = entranceHall;
    }

    
    @Override
    public void run() {
        while ( true ) {
            // thread avança para Idle
            idle.idle();
            // se simulação activa (não suspend, não stop, não end), thread avança para o outsideHall
            outsideHall.call();
            entranceHall.call();
            // mais
        }
    }
    
    
}
