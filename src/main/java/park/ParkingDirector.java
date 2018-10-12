package park;

public class ParkingDirector {
    private StringBuffer reportForm;

    public String getReportForm(ParkingManager parkingManager){
        return parkingManager.printManagerNumerOfCarsAndLots();
    }
}
