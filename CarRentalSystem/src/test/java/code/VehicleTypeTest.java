package code;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VehicleTypeTest {
    private VehicleType carType;
    private VehicleType vanType;

    @Before
    public void setUp() {
        carType = new VehicleType(6);
        vanType = new VehicleType(21, new DateTime());
    }

    @Test
    @DisplayName("This function will verify vehicleType's getSeats method for car type")
    public void CarTestGetSeats() {

        assertEquals(6, carType.getSeats("car"));
    }
    @Test
    @DisplayName("This function will verify vehicleType's getSeats method for van type")
    public void VanTestGetSeats(){

        assertEquals(21, vanType.getSeats("van"));
    }
    @Test
    @DisplayName("This function will verify vehicleType's getCarSeats method for car type")
    public void testGetCarSeats() {

        assertEquals(6, carType.getCarSeats());
    }

    @Test
    @DisplayName("This function will verify vehicleType's setCarSeats method for car type")
    public void testSetCarSeats() {
        carType.setCarSeats(5);
        assertEquals(5, carType.getCarSeats());
    }

    @Test
    @DisplayName("This function will verify vehicleType's setting last and gettingLastMaintenance method for car type")
    public void testGetLastMaintenance() {
        DateTime dateTime = new DateTime();
        vanType.setLastMaintenance(dateTime);
        assertEquals(dateTime, vanType.getLastMaintenance());
    }

    @Test
    @DisplayName("This function will verify vehicleType's carBeRentedForMinimumDays method for car type")
    public void testCarCanBeRentedForMinimumDaysEquals2() {
        assertEquals(2, carType.canBeRentedForMinimumDays(new DateTime(4), "car"));
    }
    @Test
    @DisplayName("This function will verify vehicleType's carBeRentedForMinimumDays method for car type")
    public void testCarCanBeRentedForMinimumDaysEquals3() {
        assertEquals(3, carType.canBeRentedForMinimumDays(new DateTime(2), "car"));
    }
    @Test
    @DisplayName("This function will verify vehicleType's carBeRentedForMinimumDays for van type")
    public void testVanRentedForMinimumDays(){
        assertEquals(1, vanType.canBeRentedForMinimumDays(new DateTime(1), "van"));
    }
    @Test
    @DisplayName("This function will verify vehicleType's IsUnderMaintenance for car type")
    public void testCarIsUnderMaintenance() {
        carType.setLastMaintenance(new DateTime());
        assertFalse(carType.IsUnderMaintenance(new DateTime(), "car", 5));
    }
    @Test
    @DisplayName("This function will verify vehicleType's isUnderMaintenance for car type")
    public void testVanIsUnderMaintenance() {
        vanType.setLastMaintenance(new DateTime());
        assertFalse(vanType.IsUnderMaintenance(new DateTime(), "van", 5));
    }
}