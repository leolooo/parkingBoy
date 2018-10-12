package park;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {
    private final int capacity;
    private final Map<ParkTicket,Car> parkTicketCarHashMap;

    public ParkLot(int capacity) {
        parkTicketCarHashMap = new HashMap<ParkTicket, Car>();
        this.capacity = capacity;
    }

    public ParkTicket park(Car car) {
        if (parkTicketCarHashMap.size() >= this.capacity){
            throw new IndexOutOfBoundsException("parking lot is full!");
        }
        ParkTicket ticket = new ParkTicket();
        parkTicketCarHashMap.put(ticket, car);
        return ticket;
    }

    public Car pickup(ParkTicket parkTicket) {
        return parkTicketCarHashMap.remove(parkTicket);
    }

    public boolean isFull() {
        return parkTicketCarHashMap.size() == this.capacity;
    }

    public int getParkLotSize(){
        return parkTicketCarHashMap.size();
    }

    public int getParkLotFreeRoom() {
        return capacity - parkTicketCarHashMap.size();
    }

    public double getParkLotVacancy() {
        return (capacity - parkTicketCarHashMap.size()) / (double)capacity;
    }

    public String printLotNumerOfCarsandSize() {
        StringBuffer printInfo = new StringBuffer();
        int parkLotCars = getParkLotSize() - getParkLotFreeRoom();
        printInfo.append("   P " + parkLotCars + " " + getParkLotSize() + "\n");
        return printInfo.toString();
    }
}
