/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAPaymentPoint;


public interface IPaymentPoint_Control {
    public void suspend();
    public void resume();
    public void stop();
    public void end();   
}
