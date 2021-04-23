/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Communication.Message;
import Communication.Server;
import Controller.Controller;
import java.net.SocketTimeoutException;

public class OCC_Main {
    
     public static void main(String args[]) {
         
        final String host = "127.0.0.1";
        final Integer OCCPort = 1200;
        final Integer OISPort = 1300;
        
        final Server server = new Server(OCCPort);
        Server serverX;
        
        
      
        Controller controller = new Controller(host, OISPort);
        OCC_GUI GUI = new OCC_GUI(controller);
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI.setVisible(true);
            }
        });

        server.start();
        
        do {
            try {
                Message send = new Message("Ok");
                serverX = server.accept();
                Message receive = (Message) serverX.readObject();

                switch (receive.getType()) {
                    case ("customerState"):
                        GUI.changeState(receive.getCustomerId(), receive.getCustomerState());
                        break;
                    default:
                        send = new Message("400 Bad Request");
                        break;
                }

                serverX.writeObject(send);
                serverX.close();
            } catch (SocketTimeoutException ex) {}
        } while(controller.continueSimulation());
        
        server.end();
        
            
    }
    
}
