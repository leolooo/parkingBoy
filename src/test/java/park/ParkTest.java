package park;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class ParkTest {

    @Test
    public void should_part_success_when_parkingLot_not_full(){
        ParkLot parkLot = new ParkLot(1);
        ParkTicket ticket = parkLot.park(new Car());
        assertNotNull(ticket);
    }
    @Test
    public void should_part_failed_when_parkingLot_is_full(){
        try {
            ParkLot parkLot = new ParkLot(1);
            parkLot.park(new Car());
        }catch (Exception e){
            assertThat(e).isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
    @Test
    public void should_get_indicated_card_when_pick_up_with_a_ticket(){
        ParkLot parkLot = new ParkLot(2);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkTicket parkTicket1 = parkLot.park(car1);
        ParkTicket parkTicket2 = parkLot.park(car2);
        Car pickedCar = parkLot.pickup(parkTicket2);
        assertEquals(pickedCar,car2);
    }

    @Test
    public void should_park_one_car_when_pick_up_one_car_from_full_parkingLot(){
        ParkLot parkLot = new ParkLot(2);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkTicket parkTicket1 = parkLot.park(car1);
        ParkTicket parkTicket2 = parkLot.park(car2);
        parkLot.pickup(parkTicket2);

        //when
        ParkTicket ticket3 = parkLot.park(new Car());

        //then
        assertNotNull(ticket3);
    }

    @Test
    public void should_not_be_full_after_init_parking_lot() {
        ParkLot parkLot = new ParkLot(1);
        assertFalse(parkLot.isFull());
    }
}
