package lv.javaguru.travel.insurance.core;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeService {
    public long returnBetweenDate (Date data1, Date data2) {
        var diff = data1.getTime() - data2.getTime();
        return  Math.abs(TimeUnit.MILLISECONDS.toDays(Math.abs(diff)));
    }
}
