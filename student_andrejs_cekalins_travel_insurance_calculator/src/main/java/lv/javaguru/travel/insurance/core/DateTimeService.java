package lv.javaguru.travel.insurance.core;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeService {
   long getDifferenceDays(Date date1, Date date2) {
        long dateDifference = date1.getTime() - date2.getTime();
        return TimeUnit.DAYS.convert(dateDifference,TimeUnit.MICROSECONDS);
    }
}
