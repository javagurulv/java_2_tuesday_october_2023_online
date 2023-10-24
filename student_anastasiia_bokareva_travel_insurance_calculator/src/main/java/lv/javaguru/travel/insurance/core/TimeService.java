package lv.javaguru.travel.insurance.core;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeService {

    long daysBetween (Date date, Date date2){
        long differenceDays = date.getTime()-date2.getTime();
        return TimeUnit.DAYS.convert(differenceDays,TimeUnit.MILLISECONDS);
    }
}
