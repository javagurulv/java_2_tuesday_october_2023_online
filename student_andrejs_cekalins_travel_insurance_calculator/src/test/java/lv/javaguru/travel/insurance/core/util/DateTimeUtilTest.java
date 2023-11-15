package lv.javaguru.travel.insurance.core.util;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilTest {
    private DateTimeUtil dateTimeService = new DateTimeUtil();
    SimpleDateFormat dates = new SimpleDateFormat("dd.MM.yyyy");

    @Test
    void shouldDaysBetweenBeZeroOk() throws ParseException {
        Date date1 = dates.parse("01.01.2023");
        Date date2 = dates.parse("01.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertEquals(daysBetween, 0L);
    }

    @Test
    void shouldDaysBetweenBeZeroFalse() throws ParseException {
        Date date1 = dates.parse("01.01.2023");
        Date date2 = dates.parse("07.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertNotEquals(daysBetween, 0L);
    }

    @Test
    void shouldDaysBetweenBeSevenOk() throws ParseException {
        Date date1 = dates.parse("01.01.2023");
        Date date2 = dates.parse("08.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertEquals(daysBetween, 7L);
    }

    @Test
    void shouldDaysBetweenBeSevenFalse() throws ParseException {
        Date date1 = dates.parse("01.01.2023");
        Date date2 = dates.parse("07.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertNotEquals(daysBetween, 7L);
    }

    @Test
    void shouldDaysBetweenBeNegativeOK() throws ParseException {
        Date date1 = dates.parse("08.01.2023");
        Date date2 = dates.parse("01.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertEquals(daysBetween, -7L);

    }

    @Test
    void shouldDaysBetweenBeNegativeFalse() throws ParseException {
        Date date1 = dates.parse("07.01.2023");
        Date date2 = dates.parse("01.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertNotEquals(daysBetween, -7L);

    }

}