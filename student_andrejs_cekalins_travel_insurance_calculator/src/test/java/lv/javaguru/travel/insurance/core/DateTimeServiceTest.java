package lv.javaguru.travel.insurance.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class DateTimeServiceTest {
    private DateTimeService dateTimeService;
    private Date date1;
    private Date date2;

    @BeforeEach
    void setUp() {
        dateTimeService = new DateTimeService();
        date1 = new Date();
    }

    @Test
    void getDifferenceDays() {

    }
}