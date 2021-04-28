/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SACorridor;

import SACorridorHall.*;
import SAEntranceHall.*;

/**
 *
 * @author omp
 */
public interface ICorridor_Customer {
    public int in( int customerId, int cto );
    public void out();
    public void checkTreadmill();
    public void setStopped(boolean stopped);
}
