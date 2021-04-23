

package ActiveEntity;

import Communication.Message;
import Communication.Server;
import SAIdle.IIdle_Control;
import SACorridor.ICorridor_Control;
import SACorridorHall.ICorridorHall_Control;
import SAEntranceHall.IEntranceHall_Control;
import SAOutsideHall.IOutsideHall_Control;
import SAPaymentHall.IPaymentHall_Control;
import java.net.SocketTimeoutException;

/**
 * Esta entidade é responsável por fazer executar os comandos originados no OCC
 * tais como start, stop, end, etc....
 * 
 * @author omp
 */
public class AEControl extends Thread {

    private final IIdle_Control idle;
    private final IOutsideHall_Control outsideHall;
    private final IEntranceHall_Control entranceHall;
    
    private int nCustomers;
    
    final String host = "127.0.0.1";
    final Integer OCCPort = 1200;
    final Integer OISPort = 1300;
    final Server server = new Server (OISPort);
    private Message received;
    private Message send;
    
    public AEControl( IIdle_Control idle, IOutsideHall_Control outsideHall, IEntranceHall_Control entranceHall /* mais áreas partilhadas */ ) {
        this.idle = idle;
        this.send = new Message("Ok");
        this.outsideHall = outsideHall;
        this.entranceHall = entranceHall;
    }
    
    /**public void start( int nCustomers, Socket socket ) {
        idle.start( nCustomers );
    }**/
    
     public void startSimulation(int nCustomers, int cto) {
        idle.start(nCustomers, cto);
    }
    
    public void endSimulation() {
        // terminar Customers em idle
        idle.end();
        // terminar restantes Customers e outras AE
    }
    
    
    public void suspendSimulation() {
        outsideHall.suspend();
        entranceHall.suspend();
        // terminar restantes Customers e outras AE
    }
    // mais comandos 
    
    
    @Override
    public void run() {
        
        // Reads messages from OCC and performs the corresponding actions
        
        server.start();
        
        Server serverX;
        boolean waitconnection = true;
        do {
            try {
                serverX = server.accept();
                received = (Message) serverX.readObject();
                switch(received.getType()){
                    case "Start":
                        startSimulation(received.getTnc(),received.getCto());
                        break;
                    case "End":
                        endSimulation();
                        break;
                    case "Suspend":
                        suspendSimulation();
                        break; 
                    default:
                        this.send = new Message("400 Bad Request.");
                        break;
                }
                serverX.writeObject(send);
                serverX.close();
                    } catch (SocketTimeoutException ex) {}
        } while(waitconnection);
        
        server.end();
        
    }
}
