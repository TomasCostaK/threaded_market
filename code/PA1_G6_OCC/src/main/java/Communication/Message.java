/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import java.io.Serializable;

public class Message implements Serializable{
    
    private String type = "";
    
    private int tnc = 10;
    
    private int cto = 100;
    
    private int sto = 0;
    
    private int customerId = 0;
    
    private String customerState = "";
    
    public Message(String type, int tnc, int cto, int sto) {
        this.type = type;
        this.tnc = tnc;
        this.cto = cto;
        this.sto = cto;
    }
    
    public Message(String type, int customerId, String customerState) {
        this.type = type;
        this.customerId = customerId;
        this.customerState = customerState;
    }
    
    public Message(String type) {
        this.type = type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setTnc(int tnc) {
        this.tnc = tnc;
    }
    
    public int getTnc() {
        return this.tnc;
    }
    
    public void setCto(int cto) {
        this.cto = cto;
    }
    
    public int getCto() {
        return this.cto;
    }
    
    public void setSto(int sto) {
        this.sto = sto;
    }
    
    public int getSto() {
        return this.sto;
    }   

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }  

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }
    
    public String getCustomerState() {
        return this.customerState;
    }   
    
}
