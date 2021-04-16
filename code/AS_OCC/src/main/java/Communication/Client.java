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
    

    private Socket socket = null;

    private final String serverHostName;
    
    private final int serverPortNumb;

    private ObjectInputStream in = null;
    
    private ObjectOutputStream out = null;
    

    public Client(String hostName, int portNumb) {
        serverHostName = hostName;
        serverPortNumb = portNumb;
    }

    public boolean open() {
        boolean success = true;
        SocketAddress serverAddress = new InetSocketAddress(serverHostName, serverPortNumb);
        
        try {
            socket = new Socket();
            socket.connect(serverAddress);
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        if(!success) return success;
        
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        
        try {
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        
        return success;
    }

    public void close() {
        try {
            in.close();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        try {
            out.close();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        try {
            socket.close();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
    }
    

    public Object readObject() {
        Object fromServer = null;
        try {
            fromServer = in.readObject();
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        return fromServer;
    }
    

    public void writeObject(Object toServer) {
        try {
            out.writeObject(toServer);
        }
        catch(Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
    
}
