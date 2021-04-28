

package ActiveEntity;

import Communication.Message;
import Communication.Server;
import SAIdle.IIdle_Control;
import SACorridor.ICorridor_Control;
import SACorridorHall.ICorridorHall_Control;
import SAEntranceHall.IEntranceHall_Control;
import SAOutsideHall.IOutsideHall_Control;
import SAPaymentPoint.IPaymentPoint_Control;
import java.net.SocketTimeoutException;

public class AEControl extends Thread {

    private final IIdle_Control idle;
    private final IOutsideHall_Control outsideHall;
    private final IEntranceHall_Control entranceHall;
    private final ICorridorHall_Control[] corridorHalls;
    private final ICorridor_Control[] corridors;
    private final IPaymentPoint_Control paymentPoint;
    
    final String host = "127.0.0.1";
    final Integer OCCPort = 1200;
    final Integer OISPort = 1300;
    final Server server = new Server (OISPort);
    private Message received;
    private Message send;
    
    public AEControl( IIdle_Control idle, IOutsideHall_Control outsideHall, IEntranceHall_Control entranceHall, ICorridorHall_Control[] corridorHalls, ICorridor_Control[] corridors, IPaymentPoint_Control paymentPoint) {
        this.idle = idle;
        this.send = new Message("Ok");
        this.outsideHall = outsideHall;
        this.entranceHall = entranceHall;
        this.corridorHalls = corridorHalls;
        this.corridors = corridors;
        this.paymentPoint = paymentPoint;
    }
 
    
     public void startSimulation(int nCustomers, int cto) {
        this.idle.start(nCustomers, cto);
    }
    
    public void endSimulation() {
        this.idle.end();
        this.outsideHall.end();
        this.entranceHall.end();
        this.corridorHalls[0].end();
        this.corridorHalls[1].end();
        this.corridorHalls[2].end();     
        this.corridors[0].end();
        this.corridors[1].end();
        this.corridors[2].end();
        this.paymentPoint.end();
    }
    
    public void stopSimulation() {
        this.outsideHall.stop();
        this.entranceHall.stop();
        this.corridorHalls[0].stop();
        this.corridorHalls[1].stop();
        this.corridorHalls[2].stop();  
        this.corridors[0].stop();
        this.corridors[1].stop();
        this.corridors[2].stop();
        this.paymentPoint.stop();
        
    }
    
    
    public void suspendSimulation() {
        this.outsideHall.suspend();
        this.entranceHall.suspend();
        this.corridorHalls[0].suspend();
        this.corridorHalls[1].suspend();
        this.corridorHalls[2].suspend();
        this.corridors[0].suspend();
        this.corridors[1].suspend();
        this.corridors[2].suspend();
        this.paymentPoint.suspend();
    }
    
    
    public void resumeSimulation() {
        this.outsideHall.resume();
        this.entranceHall.resume();
        this.corridorHalls[0].resume();
        this.corridorHalls[1].resume();
        this.corridorHalls[2].resume();
        this.corridors[0].resume();
        this.corridors[1].resume();
        this.corridors[2].resume();
        this.paymentPoint.resume();
    }

    
    @Override
    public void run() {
       
        // Reads messages from OCC and performs the corresponding actions
        
        this.server.start();
        
        Server serverX;
        boolean waitconnection = true;
        do {
            try {
                serverX = server.accept();
                this.received = (Message) serverX.readObject();
                switch(received.getType()){
                    case "Start":
                        startSimulation(received.getTnc(),received.getCto());
                        break;
                    case "End":
                        endSimulation();
                        break;
                    case "Stop":
                        stopSimulation();
                        break;
                    case "Suspend":
                        suspendSimulation();
                        break; 
                    case "Resume":
                        resumeSimulation();
                        break; 
                    default:
                        this.send = new Message("400 Bad Request.");
                        break;
                }
                serverX.writeObject(this.send);
                serverX.close();
                    } catch (SocketTimeoutException ex) {}
        } while(waitconnection);
        
        this.server.end();
        
    }
}
