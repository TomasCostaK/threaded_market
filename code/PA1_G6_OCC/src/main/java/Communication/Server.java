/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class Server {

   private ServerSocket listeningSocket = null;

   private Socket socket = null;

   private final int serverPortNumb;

   private ObjectInputStream in = null;

   private ObjectOutputStream out = null;

   public Server(int portNumb) {
      this.serverPortNumb = portNumb;
   }

   public Server(int portNumb, ServerSocket lSocket) {
      this.serverPortNumb = portNumb;
      this.listeningSocket = lSocket;
   }

   public void start() {
      try {
          this.listeningSocket = new ServerSocket(this.serverPortNumb);
          setTimeout(1000);
      }
      catch(Exception e) {
          System.err.println(e);
      }
   }

   public void end() {
      try {
          this.listeningSocket.close();
      }
      catch(Exception e) {
          System.err.println(e);
      }
   }

   public Server accept() throws SocketTimeoutException {
      Server server;

      server = new Server(this.serverPortNumb, this.listeningSocket);
      
      try {
          server.socket = this.listeningSocket.accept();
      }
      catch(SocketTimeoutException e) {
          throw new SocketTimeoutException("Timeout!");
      }
      catch(SocketException e) {
          System.exit(1);
      }
      catch(IOException e) {
          System.exit(1);
      }

      try {
          server.in = new ObjectInputStream(server.socket.getInputStream());
      }
      catch(Exception e) {
          System.exit(1);
      }
     
      try {
          server.out = new ObjectOutputStream(server.socket.getOutputStream());
      }
      catch(Exception e) {
          System.exit(1);
      }

      return server;
   }

   public void close() {
      try {
          this.in.close();
      }
      catch(Exception e) {
          System.err.println(e);
      }

      try {
          this.out.close();
      }
       catch(Exception e) {
          System.err.println(e);
      }

      try {
          socket.close();
      }
       catch(Exception e) {
          System.err.println(e);
      }
   }

   public void setTimeout(int time) {
      try {
          listeningSocket.setSoTimeout(time);
      }
      catch(Exception e) {
          System.err.println(e);
      }
   }

   public Object readObject() {
      Object fromClient = null;

      try {
          fromClient = in.readObject();
      }
      catch(Exception e) {
          System.err.println(e);
      }

      return fromClient;
   }

   public void writeObject(Object toClient) {
      try {
          this.out.writeObject(toClient);
      }
      catch(Exception e) {
          System.err.println(e);
      }
   }
}
