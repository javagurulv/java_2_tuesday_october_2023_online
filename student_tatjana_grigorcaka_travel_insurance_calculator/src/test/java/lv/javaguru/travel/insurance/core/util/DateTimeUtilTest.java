package lv.javaguru.travel.insurance.core.util;

import lv.javaguru.travel.insurance.core.util.DateTimeUtil;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeUtilTest {

    private DateTimeUtil dateTimeUtil = new DateTimeUtil();
    @Test
    public void testDaysBetweenZero(){
        Date date1 = createDate("01.01.2024");
        Date date2 = createDate("01.01.2024");
        var daysBetween = dateTimeUtil.getDaysBetween(date1, date2);
        assertEquals(daysBetween, 0L);
    }
    @Test
    public void testDaysBetweenPositive(){
        Date date1 = createDate("01.01.2024");
        Date date2 = createDate("15.01.2024");
        var daysBetween = dateTimeUtil.getDaysBetween(date1, date2);
        assertEquals(daysBetween, 14L);
    }
    @Test
    public void testDaysBetweenNegative(){
        Date date1 = createDate("01.01.2024");
        Date date2 = createDate("25.12.2023");
        var daysBetween = dateTimeUtil.getDaysBetween(date1, date2);
        assertEquals(daysBetween, -7L);
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}