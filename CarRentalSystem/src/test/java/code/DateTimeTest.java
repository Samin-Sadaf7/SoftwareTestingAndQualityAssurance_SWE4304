package code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTimeTest {
    private static DateTime dateTime;
    @BeforeAll
    public static void setUp() {
        dateTime=new DateTime(13,3 , 2024);
    }

    @Test
    public void testGetFormattedTime() {
        assertEquals("13/03/2024", dateTime.getFormattedDate());
    }

    @Test
    public void testGetEightDigitDate() {
        assertEquals("13032024", dateTime.getEightDigitDate());
    }
    @Test
    public void testGetCurrentTime(){
        assertEquals("2024-03-13", DateTime.getCurrentTime());
    }
    @Test
    public void testDiffDays() {
        DateTime startDate = new DateTime(25, 2, 2024);
        DateTime endDate = new DateTime(28, 2, 2024);

        assertEquals(3, DateTime.diffDays(endDate, startDate));
    }

    @Test
    public void testSetAdvance() {
        DateTime dateTime = new DateTime(29, 1, 2022);
        dateTime.setAdvance(3,2,1);
        assertEquals(266400000, dateTime.advance);
    }

    @Test
    public void testGetNameOfDay() {
        assertEquals("Wednesday", dateTime.getNameOfDay());
    }
}