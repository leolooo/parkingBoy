package park;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingBoyTest {

    @Test
    public void should_park_into_first_parkingLot_when_first_parkingLot_is_not_full(){
        //given
        ParkLot parkLot1 = new ParkLot(1);
        ParkLot parkLot2 = new ParkLot(1);

        ParkingBoy parkingBoy = new ParkingBoy(parkLot1, parkLot2);

        //when
        ParkTicket ticket = parkingBoy.park(new Car());

        //then
        assertTrue(parkLot1.isFull());
        assertFalse(parkLot2.isFull());
    }

    @Test
    public void should_park_into_second_parkingLot_when_first_parkingLot_is_full(){
        //given
        ParkLot parkLot1 = new ParkLot(1);
        ParkLot parkLot2 = new ParkLot(1);

        ParkingBoy parkingBoy = new ParkingBoy(parkLot1, parkLot2);

        //when
        ParkTicket ticket1 = parkingBoy.park(new Car());
        ParkTicket ticket2 = parkingBoy.park(new Car());

        //then
        assertTrue(parkLot1.isFull());
        assertTrue(parkLot2.isFull());
    }
    @Test
    public void should_throw_exception_when_parkingLots_is_full(){

        try{
            //given
            ParkLot parkLot1 = new ParkLot(1);
            ParkLot parkLot2 = new ParkLot(1);
            ParkingBoy parkingBoy = new ParkingBoy(parkLot1, parkLot2);
            //when
            ParkTicket ticket1 = parkingBoy.park(new Car());
            ParkTicket ticket2 = parkingBoy.park(new Car());
        }catch (Exception e){
            assertThat(e).isInstanceOf(IndexOutOfBoundsException.class);
        }

    }

}
