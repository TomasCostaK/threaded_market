/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActiveEntity;

import ManagerHall.ManagerHall;
import SAEntranceHall.IEntranceHall_Manager;
import SAIdle.IIdle_Manager;
import SAOutsideHall.IOutsideHall_Manager;
import java.util.concurrent.TimeUnit;

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
    private final ManagerHall managerHall;
    
    public AEManager(IIdle_Manager idle, IOutsideHall_Manager outsideHall, IEntranceHall_Manager entranceHall, ManagerHall managerHall /* mais args */ ) {
        this.idle = idle;
        this.outsideHall = outsideHall;
        this.entranceHall = entranceHall;
        this.managerHall = managerHall;
    }

    
    @Override
    public void run() {
        while ( true ) {
            try{
                // thread avança para Idle
                idle.idle();
                // se simulação activa (não suspend, não stop, não end), thread avança para o outsideHall
                while(true){
                    managerHall.in();
                    //System.out.println("Manager in outside hall\n");
                    outsideHall.call();
                    //System.out.println("Manager in entrance hall\n");
                    entranceHall.call();
                }
                // mais
            }
            catch(Exception e) {}
            
        }
    }
    
    
}
