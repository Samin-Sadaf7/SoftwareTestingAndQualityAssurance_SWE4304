package code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.DisplayName;

public class CarTest {
    private Car car;

    @Before
    public void setUp() {
        VehicleType vehicleType = new VehicleType(4);
        car = new Car("C_001", 2000, "Make", "Model", 0, vehicleType);
    }

    @Test
    @DisplayName("Test should return valid late fee")
    public void testGetLateFee() {
        DateTime expected_returnDay = new DateTime(1);
        DateTime actual_returnDay = new DateTime(3);
        car.rent("C_001", new DateTime(), 1);
        car.returnVehicle(actual_returnDay);
        double expected_fee = 1.25*78*2;
        assertEquals(expected_fee, car.getLateFee(actual_returnDay,expected_returnDay), 0.001);
    }

    @Test
    @DisplayName("Test should return 0 as valid late fee if car start date and end date is equal")
    public void testGetLateFee2() {
        DateTime expected_returnDay = new DateTime(1);
        DateTime actual_returnDay = new DateTime(1);
        VehicleType vehicleType = new VehicleType(7);
        car = new Car("C_001", 2000, "Make", "Model", 0, vehicleType);
        car.rent("C_001", new DateTime(), 1);
        car.returnVehicle(actual_returnDay);
        assertEquals(0, car.getLateFee(actual_returnDay,expected_returnDay), 0.001);
    }



    @Test
    @DisplayName("Test should test a date is Return Date or not")
    public void testReturnVehicle() {
        assertFalse(car.returnVehicle(new DateTime()));
    }

    @Test
    @DisplayName("Test should return the car has complete maintenance or not ")
    public void testCompleteMaintenance() {
        assertFalse(car.completeMaintenance());
    }

    @Test
    @DisplayName("Test should return details of car")
    public void testGetDetails() {
        String expected = "Vehicle ID:\tC_001\n Year:\t 2000\n Make:\tMake\n Model:\tModel\n Number of Seats:\t4\n Status:\tAvailable\nRENTAL RECORD:\tempty";
        assertEquals(expected, car.getDetails());
    }
}
