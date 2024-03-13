package code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalRecordTest{

    private static DateTime rentDateMock;
    private static DateTime estimatedReturnDateMock;
    private static DateTime actualReturnDateMock;

    @BeforeAll
    public static void setUp() {
        rentDateMock = Mockito.mock(DateTime.class);
        estimatedReturnDateMock = Mockito.mock(DateTime.class);
        actualReturnDateMock = Mockito.mock(DateTime.class);

        Mockito.when(rentDateMock.toString()).thenReturn("2022-04-05");
        Mockito.when(estimatedReturnDateMock.toString()).thenReturn("2022-04-10");
        Mockito.when(actualReturnDateMock.toString()).thenReturn("2022-04-12");
    }

    @Test
    public void testGetDetails_NoData() {
        RentalRecord record = new RentalRecord("R_001", rentDateMock, estimatedReturnDateMock);
        String expected = """
                Record ID:             R_001
                Rent Date:             2022-04-05
                Estimated Return Date: 2022-04-10""";
        assertEquals(expected, record.getDetails());
    }

    @Test
    public void testGetDetails_WithData() {
        RentalRecord record = new RentalRecord("R_002", rentDateMock, estimatedReturnDateMock);
        record.setData(actualReturnDateMock, 200.30, 70.10);

        String expected = """
                Record ID:             R_002
                Rent Date:             2022-04-05
                Estimated Return Date: 2022-04-10
                Actual Return Date:    2022-04-12
                Rental Fee:            200.30
                Late Fee:              70.10""";
        assertEquals(expected, record.getDetails());
    }

    @Test
    public void testToString_NoData() {
        RentalRecord record = new RentalRecord("R_003", rentDateMock, estimatedReturnDateMock);
        String expected = "R_003:2022-04-05:2022-04-10:none:none:none";
        assertEquals(expected, record.toString());
    }

    @Test
    public void testToString_WithData() {
        RentalRecord record = new RentalRecord("R_004", rentDateMock, estimatedReturnDateMock);
        record.setData(actualReturnDateMock, 300.00, 70.25);

        String expected = "R_004:2022-04-05:2022-04-10:2022-04-12:300.0:70.25";
        assertEquals(expected, record.toString());
    }

    @Test
    public void testGetEstimatedReturnDate() {
        RentalRecord record = new RentalRecord("R_005", rentDateMock, estimatedReturnDateMock);
        assertEquals(estimatedReturnDateMock, record.getEstimatedReturnDate());
    }
}