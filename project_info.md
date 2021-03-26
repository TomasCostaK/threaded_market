# OurMarket

## Shared Areas
The shared areas all implement the methods of the interfaces it contains.

    (control is present in all of them)
    - OutsideHall (multiple clients) + Manager 
    - EntranceHall (up to 6 clients) + Manager
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
    - listen()      - wait to be called by the manager
    - leave()       - exit the queue

Interface EntranceHall Customer:

    - enter()
    - listen()
    - leave()

Interface CorridorHall Customer:

    - enter()
    - checkCorridor()   - verify if it can advance to the corridor
    - leave()

Interface Corridor Customer:

    - enter()
    - checkTreadmill()  - verify if he can walk forward
    - forward()         - walk forward in the corridor
    - stop()            - stop walking
    - leave()

Interface PaymentHall Customer:

    - enter()
    - listen()
    - leave()

Interface PaymentPoint Customer:

    - enter()
    - leave()

### Manager
Interface OutsideHall Manager:

    - checkNextSection()    - verify if he can send clients to the next section (EntranceHall)
    - callClient()          - envia o cliente para a proxima secçao
    - returnToManagerHall() - volta ao managerHall

Interface EntranceHall Manager:

    - checkNextSection()    - verify if he can send clients to the next section (one of the CorridorHalls)
    - callClient() 
    - returnToManagerHall()

Interface ManagerHall Manager:

    - checkClients()        - verify if queues of OutsideHall or EntranceHall are not empty (there's clients waiting)


### Cashier
Interface PaymentPoint Cashier:

    - checkClients()
    - callClient()


## Data structure

    - OutsideHall: FIFO with size TNC (total number of customer), smaller IDs have priority
    - EntranceHall: FIFO with size 6
    - CorridorHalls: FIFO with size 3
    - Corridors: FIFO with size 2
    - PaymentHall: FIFO with size 2
    - PaymentPoint: -