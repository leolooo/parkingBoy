package park;

import java.util.List;

public class ParkingManager extends ParkingBoy{
    private List<ParkingBoy> nomalParkingBoys;
    private List<SmartParkingBoy> smartParkingBoys;
    private List<SuperParkingBoy> superParkingBoys;
    public ParkingManager(List<ParkingBoy> nomalParkingBoys, List<SmartParkingBoy> smartParkingBoys, List<SuperParkingBoy> superParkingBoys, ParkLot...parkLots){
        super(parkLots);
        this.nomalParkingBoys = nomalParkingBoys;
        this.smartParkingBoys = smartParkingBoys;
        this.superParkingBoys = superParkingBoys;
    }
    @Override
    public ParkTicket park(Car car) {
        for (ParkLot parkLot : parkLots) {
            if (!parkLot.isFull()) {
                return parkLot.park(car);
            }
        }
        throw new IndexOutOfBoundsException("ParkingManager的停车场满了！");
    }

    public ParkTicket orderBoyToPark(ParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }

    public ParkTicket orderSmartBoyToPark(SmartParkingBoy smartParkingBoy, Car car) {
        return smartParkingBoy.park(car);
    }

    public ParkTicket orderSuperBoyToPark(SuperParkingBoy superParkingBoy, Car car) {
        return superParkingBoy.park(car);
    }

    public String printManagerNumerOfCarsAndLots(){
        StringBuffer printInfo = new StringBuffer();
        StringBuffer printInfoOfBoys = new StringBuffer();

        int parkingCarsTotalNumber = 0, lotsTotalSize = 0;
        for(ParkingBoy nomalParkingBoys : nomalParkingBoys){
            printInfoOfBoys.append(nomalParkingBoys.printBoyNumerOfCarsAndLots());
            parkingCarsTotalNumber += nomalParkingBoys.getNumberOfParkingCars();
            lotsTotalSize += nomalParkingBoys.getNumberOfAllLotsSize();
        }

        for(SmartParkingBoy smartParkingBoy : smartParkingBoys){
            printInfoOfBoys.append(smartParkingBoy.printBoyNumerOfCarsAndLots());
            parkingCarsTotalNumber += smartParkingBoy.getNumberOfParkingCars();
            lotsTotalSize += smartParkingBoy.getNumberOfAllLotsSize();
        }

        for(SuperParkingBoy superParkingBoy : superParkingBoys){
            printInfoOfBoys.append(superParkingBoy.printBoyNumerOfCarsAndLots());
            parkingCarsTotalNumber += superParkingBoy.getNumberOfParkingCars();
            lotsTotalSize += superParkingBoy.getNumberOfAllLotsSize();
        }

        printInfo.append("M" + parkingCarsTotalNumber + " " + lotsTotalSize);
        printInfo.append(printInfoOfBoys);

        return printInfo.toString();
    }
}
