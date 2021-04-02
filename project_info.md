# OurMarket

## Shared Areas
The shared areas all implement the methods of the interfaces it contains.

    (control is present in all of them)
    - OutsideHall (multiple clients) + Manager 
    - EntranceHall (up to 6 clients) + Manager
    - ManagerHall (Manager + client notifying)
    - CorridorHalls (up to 3 clients per corridorHall)
    - Corridors (up to 2 clients)
    - PaymentHall (up to 2 clients)
    - PaymentPoint (1 client) + Cashier

## Methods

### Control
Interface Control: (common to all rooms)

        - StartSimulation()
        - EndSimulation()
        - SuspendSimulation()
        - StopSimulation()
        - ResumeSimulation()

### Customer
Interface OutsideHall Customer:

    - enter()
    - notifyManagerArrival()      - warn manager of arrival
    - leave()                     - exit the queue

Interface EntranceHall Customer:

    - enter()
    - notifyManagerArrival()    - warn manager that client is going to next room
    - notifyManagerDeparture()    - warn manager that client is going to next room
    - leave()

Interface CorridorHall Customer:

    - enter()
    - checkCorridor()   - verify if it can advance to the corridor
    - notifyManagerDeparture()    - warn manager that client is going to next room
    - leave()

Interface Corridor Customer:

    - enter()
    - checkTreadmill()  - verify if he can walk forward
    - forward()         - walk forward in the corridor
    - stop()            - stop walking
    - leave()

Interface PaymentHall Customer:

    - enter()
    - notifyCashierArrival()    - warn cashier that client is ready to pay
    - leave()

Interface PaymentPoint Customer:

    - enter()
    - leave()

### Manager
Interface OutsideHall Manager:

    - callClient()          - envia o cliente para a proxima secçao
    - goManagerHall()       - return to the manager hall

Interface EntranceHall Manager:

    - callClient()          - envia o cliente para a proxima secçao
    - goManagerHall()       - return to the manager hall

Interface ManagerHall Manager:

    - listenClients()        - wait for clients to notify him, they either joined or left a room


### Cashier
Interface PaymentPoint Cashier:

    - listenClients()       - await for clients to notify him
    - callClient()          - call next client in line to pay


## Data structure

    - OutsideHall: FIFO with size TNC (total number of customer), smaller IDs have priority
    - EntranceHall: FIFO with size 6
    - CorridorHalls: FIFO with size 3
    - Corridors: FIFO with size 2
    - PaymentHall: FIFO with size 2
    - PaymentPoint: - 


## Notes

Quando são criados, entrar num array para que sejam condiçoes de threads.
Serem os clientes a avisar o manager. O manager está em wait e quando os clientes avançam, notificam o manager.
O cliente quando chega À caixa de pagamento avisa que está pronto.

Controlo tem start, suspend, etc... (em modo manual vs automatico)