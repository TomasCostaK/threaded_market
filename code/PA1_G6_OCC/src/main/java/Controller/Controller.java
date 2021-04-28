/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Communication.Client;
import Communication.Message;

public class Controller {
    
    private Message messageSent;
    private Message messageReceived;
    private final String host;
    private final Integer port;
    private boolean continueSimulation;
    
    public Controller (String host, Integer port) {
        this.host = host;
        this.port = port;
        this.continueSimulation = true;
    }
    
    
    public void startSimulation(int tnc, int sto, int cto) {
        System.out.println("Started");
        messageSent = new Message("Start", tnc, sto, cto);
        sendMessage();
    }
    
    public void suspendSimulation() {
        System.out.println("Suspend");
        messageSent = new Message("Suspend");
        sendMessage();
    }
    
    public void resumeSimulation() {
        System.out.println("Resume");
        messageSent = new Message("Resume");
        sendMessage();
    }

    public void stopSimulation() {
        System.out.println("Stop");
        messageSent = new Message("Stop");
        sendMessage();
    }
    
    public void endSimulation() {
        System.out.println("Ended");
        messageSent = new Message("End");
        sendMessage();
    }
    
    public boolean continueSimulation() {
        return this.continueSimulation;
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

