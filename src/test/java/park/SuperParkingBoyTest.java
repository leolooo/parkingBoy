package park;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperParkingBoyTest {
    @Test
    public void should_park_into_the_first_parkingLot_when_all_parkingLots_is_empty(){
        //given
        ParkLot parkLot1 = new ParkLot(2);
        ParkLot parkLot2 = new ParkLot(1);

        //when
        SmartParkingBoy boy = new SmartParkingBoy(parkLot1,parkLot2);
        boy.park(new Car());

        //then
        assertThat(parkLot1.getParkLotSize()).isEqualTo(1);
    }

    @Test
    public void should_park_into_largest_vacancy_room_parkingLot(){
        //given
        ParkLot parkLot1 = new ParkLot(2);
        ParkLot parkLot2 = new ParkLot(2);
        SmartParkingBoy boy = new SmartParkingBoy(parkLot1,parkLot2);

        //when
        ParkTicket ticket1 = boy.park(new Car());
        ParkTicket ticket2 = boy.park(new Car());

        //then
        assertThat(parkLot1.getParkLotSize()).isEqualTo(1);
        assertThat(parkLot2.getParkLotSize()).isEqualTo(1);
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

        }catch (Exception e){
            assertThat(e).isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}
