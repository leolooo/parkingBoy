package park;

import java.util.Arrays;
import java.util.List;
/*
 * parkingBoy按照顺序存车
 */

public class ParkingBoy {
    public List<ParkLot> parkLots;

    public ParkingBoy(ParkLot... parkLot) {
        this.parkLots = Arrays.asList(parkLot);
    }

    public ParkTicket park(Car car) {
        for (ParkLot parkLot : parkLots) {
            if (!parkLot.isFull()) {
                return parkLot.park(car);
            }
        }
        throw new IndexOutOfBoundsException("ParkingBoy的停车场满了！");
    }

    public Car pickup(ParkTicket ticket) {
        for (ParkLot parkLot : parkLots){
            Car car = parkLot.pickup(ticket);
            if (car != null){
                return car;
            }
        }
        throw new IndexOutOfBoundsException("ticket无效！");
    }
    public boolean allParkLotsIsFull() {
        for (ParkLot parkLot : parkLots) {
            if (!parkLot.isFull()) {
                return false;
            }
        }
        return true;
    }

    public String printBoyNumerOfCarsAndLots(){
        StringBuffer printInfo = new StringBuffer();
        printInfo.append("   B " + getNumberOfParkingCars() + " " + getNumberOfAllLotsSize() + "\n");
        for(ParkLot parkLot : parkLots){
            printInfo.append(parkLot.printLotNumerOfCarsandSize());
        }
        return printInfo.toString();
    }

    public int getNumberOfAllLotsSize() {
        int numberOfAllLotsSize = 0;
        for(ParkLot parkLot : parkLots){
            numberOfAllLotsSize += parkLot.getParkLotSize();
        }
        return numberOfAllLotsSize;
    }

    public int getNumberOfParkingCars(){
        int numberOfParkingCar = 0;
        for(ParkLot parkLot : parkLots){
            numberOfParkingCar += parkLot.getParkLotSize() - parkLot.getParkLotFreeRoom();
        }
        return numberOfParkingCar;
    }
}

