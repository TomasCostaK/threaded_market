/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
    

    private Socket socket;

    private final String serverHostName;
    
    private final int serverPortNumb;

    private ObjectInputStream in = null;
    
    private ObjectOutputStream out = null;
    

    public Client(String hostName, int portNumb) {
        this.serverHostName = hostName;
        this.serverPortNumb = portNumb;
        this.socket = null;
    }

    public boolean open() {
        boolean success = true;
        SocketAddress serverAddress = new InetSocketAddress(this.serverHostName, this.serverPortNumb);
        
        try {
            this.socket = new Socket();
            this.socket.connect(serverAddress);
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        if(!success) return success;
        
        try {
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        
        try {
            this.in = new ObjectInputStream(this.socket.getInputStream());
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        
        return success;
    }

    public void close() {
        try {
            this.in.close();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        try {
            this.out.close();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        try {
            this.socket.close();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
    }
    

    public Object readObject() {
        Object fromServer = null;
        try {
            fromServer = this.in.readObject();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        return fromServer;
    }
    

    public void writeObject(Object toServer) {
        try {
            this.out.writeObject(toServer);
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
    
}
