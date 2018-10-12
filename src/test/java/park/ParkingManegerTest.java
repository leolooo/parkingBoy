package park;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingManegerTest {
    @Test
    public void should_park_into_first_parkingLot_when_parking_manager_order_parkingBoy1_to_park(){
        //given
        ParkLot parkLot1 = new ParkLot(1);
        ParkLot parkLot2 = new ParkLot(1);
        ParkingBoy parkingBoy1 = new ParkingBoy(parkLot1, parkLot2);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkLot2);
        List<ParkingBoy> parkingBoys = new ArrayList();
        parkingBoys.add(parkingBoy1);
        parkingBoys.add(parkingBoy2);
        ParkingManager parkingManager = new ParkingManager(parkingBoys, null, null, parkLot1, parkLot2);

        //when
        ParkTicket ticket = parkingManager.orderBoyToPark(parkingBoy1, new Car());

        //then
        assertTrue(parkLot1.isFull());
    }

}
