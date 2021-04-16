/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

/**
 *
 * @author alina
 */
public class NotifyCustomerState {
    
    private Message messageSent;
    private Message messageReceived;
    private final String host;
    private final Integer port;
    
    public NotifyCustomerState () {
        this.host = "127.0.0.1";
        this.port = 1200;
    }
   
    public void sendCustomerState(String state, int customerId) {
        messageSent = new Message("customerState", customerId, state);
        sendMessage();
    }
    
    private void sendMessage() {
        Client con = new Client(host, port);
        
        while (!con.open()) {
            try {
                Thread.currentThread().sleep((long) 10);
            }
            catch (InterruptedException e) { }
        }
        
        con.writeObject(messageSent);
        
        messageReceived = (Message) con.readObject();
        
        
        con.close();
    }
}
