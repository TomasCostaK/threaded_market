/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAIdle;

public interface IIdle_Customer {
    public int idle( int customerId, int stopped );
    public void setFirstStopped(boolean firstStopped);
    public void setPreviousCustomerId();
}
