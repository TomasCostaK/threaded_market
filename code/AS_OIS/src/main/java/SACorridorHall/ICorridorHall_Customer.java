/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SACorridorHall;

/**
 *
 * @author omp
 */
public interface ICorridorHall_Customer {
    public void in( int customerId );
    public int out( int customerId );
    public boolean checkCorridor();
    public void setStopped( boolean stopped );
}

