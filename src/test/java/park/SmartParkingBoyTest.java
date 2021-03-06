package park;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class SmartParkingBoyTest {
    @Test
    public void should_park_into_largest_room_parkingLot(){
        ParkLot parkLot1 = new ParkLot(2);
        ParkLot parkLot2 = new ParkLot(1);
        SmartParkingBoy boy = new SmartParkingBoy(parkLot1,parkLot2);
        boy.park(new Car());
        assertThat(parkLot1.getParkLotSize()).isEqualTo(1);
    }

    @Test
    public void should_park_fail_when_all_parkingLots_is_full(){
        try {
            //given
            ParkLot parkLot1 = new ParkLot(1);
            ParkLot parkLot2 = new ParkLot(1);
            SmartParkingBoy boy = new SmartParkingBoy(parkLot1,parkLot2);

            //when
            ParkTicket ticket1 = boy.park(new Car());
            ParkTicket ticket2 = boy.park(new Car());
            ParkTicket ticket3 = boy.park(new Car());

        }catch (Exception e){
        assertThat(e).isInstanceOf(IndexOutOfBoundsException.class);
    }
    }
}
