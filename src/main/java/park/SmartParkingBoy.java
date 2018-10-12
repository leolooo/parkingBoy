package park;
/*
 * SmartParkingBoy在空位最多的停车场存车
 */
public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkLot... parkLot) {
        super(parkLot);
    }
    @Override
    public ParkTicket park(Car car) {
        if (allParkLotsIsFull()){
            throw new IndexOutOfBoundsException("全部停车场满了！");
        }
        ParkLot largestRoomParkLot = parkLots.get(0);
        for (ParkLot parkLot : parkLots){
            if (parkLot.getParkLotFreeRoom() > largestRoomParkLot.getParkLotFreeRoom()){
                largestRoomParkLot = parkLot;
            }
        }
        return largestRoomParkLot.park(car);
    }
}
