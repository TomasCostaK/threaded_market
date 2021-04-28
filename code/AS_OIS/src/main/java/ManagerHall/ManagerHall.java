/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerHall;

import SAEntranceHall.IEntranceHall_Manager;
import SAOutsideHall.IOutsideHall_Manager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alina
 */
public class ManagerHall {
    
    final IOutsideHall_Manager outsideHall;
    final IEntranceHall_Manager entranceHall;
    
    public ManagerHall(IOutsideHall_Manager outsideHall, IEntranceHall_Manager entranceHall ) {
        this.outsideHall = outsideHall;
        this.entranceHall = entranceHall;
    }
    
    public void in() {
        while(!checkOutsideHallAndEntranceHall()) {
            try {
                Thread.sleep(100);
                System.out.println("Manager in Manager Controll Hall.");
            } catch (InterruptedException ex) {
                
            }
        } 
    }
    
    
    public boolean checkOutsideHallAndEntranceHall() {
        return outsideHall.getFifoOutsideHall().getCount() > 0 || entranceHall.getFifoEntranceHall().getCount() > 0;
    }
    
}
