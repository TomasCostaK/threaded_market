/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAOutsideHall;

import FIFO.FIFO;

/**
 *
 * @author omp
 */
public interface IOutsideHall_Manager {
    public void call();
    public FIFO getFifoOutsideHall();
}
