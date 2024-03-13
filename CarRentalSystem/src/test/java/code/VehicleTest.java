
package code;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;


public class VehicleTest {
    private Vehicle VehicleCar;
    private Vehicle VehicleVan;

    private Vehicle unavailable_vehicle;

    @Before
    public void setUp() {
        VehicleType car = new VehicleType(5);
        VehicleCar = new Vehicle("C_001", 2024, "Wood", "Model", 0, car);
        DateTime dateTime = new DateTime();
        VehicleType van = new VehicleType(15, dateTime);
        VehicleVan = new Vehicle("V_001", 2023, "Strings", "Model", 0, van);
        VehicleType unavailable = new VehicleType(4);
        unavailable_vehicle = new Vehicle("U_001", 2022, "Making", "Model", 2, unavailable);
    }

    @Test
    @DisplayName("Test should verify the behavior of a method called get vehicle id for a car")
    public void testGetVehicleIdForCar() {

        assertEquals("C_001", VehicleCar.getVehicleId());
    }

    @Test
    @DisplayName("Test should verify the behavior of a method called get vehicle id for a van")
    public void testGetVehicleIdForVan() {

        assertEquals("V_001", VehicleVan.getVehicleId());
    }

    @Test
    @DisplayName("Test should verify the behavior of rent for a car.Test should return true if car is rented successfully")
    public void testRentForCar1() {

        assertTrue(VehicleCar.rent("CC_123", new DateTime(), 5));
    }
    @Test
    @DisplayName("Test should verify the behavior of rent for a car.Test should return false if car can't be rented")
    public void testRentForCar2() {
        assertFalse(VehicleCar.rent("CC_124", new DateTime(), 14));
    }

    @Test
    @DisplayName("Test should verify the behavior of rent for a van.Test should return true if van is rented successfully")
    public void testRentForVan1() {

        assertTrue(VehicleVan.rent("VV_123", new DateTime(), 5));
    }
    @Test
    @DisplayName("Test should verify the behavior of rent for a van.Test should return false if van can't be rented")
    public void testRentForVan2() {
        assertFalse(VehicleVan.rent("VV_124", new DateTime(), 0));
    }
    @Test
    @DisplayName("Test should verify the behavior of rent for a van.Test should return false if vehicle is under maintenance")
    public void testRentForVan3() {
        assertFalse(unavailable_vehicle.rent("U_123", new DateTime(), 5));
    }

    @Test
    @DisplayName("Test should verify the behavior of perform maintenance for a car")
    public void testPerformMaintenanceForCar() {
        assertTrue(VehicleCar.performMaintenance());
    }

    @Test
    @DisplayName("Test should verify the behavior of perform maintenance for a van")
    public void testPerformMaintenanceForVan() {
        assertTrue(VehicleVan.performMaintenance());
    }

    @Test
    @DisplayName("Test should verify the behavior of perform maintenance for a vehicle which is already under maintenance")
    public void testPerformMaintenanceForUnavailableVehicle() {
        assertFalse(unavailable_vehicle.performMaintenance());
    }

    @Test
    @DisplayName("Test should verify the behavior of return vehicle for a car")
    public void testToStringForCar() {
        String expectedString = "C_001:2024:Wood:Model:5:Available";
        assertEquals(expectedString, VehicleCar.toString());
    }

    @Test
    @DisplayName("Test should verify the behavior of return vehicle for a van")
    public void testToStringForVan() {
        String expectedString = "V_001:2023:Strings:Model:15:Available";
        assertEquals(expectedString, VehicleVan.toString());
    }

    @Test
    @DisplayName("Test should verify the behavior of get details for a car")
    public void testGetDetailsForCar() {
        String expectedString = "Vehicle ID:\tC_001\n Year:\t 2024\n Make:\tWood\n Model:\tModel\n Number of Seats:\t5\n Status:\tAvailable";
        assertEquals(expectedString, VehicleCar.getDetails());
    }

    @Test
    @DisplayName("Test should verify the behavior of get details for a van")
    public void testGetDetailsForVan() {
        String expected = "Vehicle ID:\tV_001\n Year:\t 2023\n Make:\tStrings\n Model:\tModel\n Number of Seats:\t15\n Status:\tAvailable";
        assertEquals(expected, VehicleVan.getDetails());
    }

    @Test
    @DisplayName("Test should verify the behavior of get last element index")
    public void testGetLastElementIndexBeforeInput () {
        assertEquals(-1, VehicleCar.getLastElementIndex());
    }
    @Test
    @DisplayName("Test should verify the behavior of get last element index")
    public void testGetLastElementIndexAfterInput () {
        VehicleCar.rent("C_123", new DateTime(), 5);
        assertEquals(0, VehicleCar.getLastElementIndex());
    }
}