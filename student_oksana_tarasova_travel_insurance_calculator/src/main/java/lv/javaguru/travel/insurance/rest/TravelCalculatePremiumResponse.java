package lv.javaguru.travel.insurance.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@Getter
@Setter

public class TravelCalculatePremiumResponse {

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;
    private BigDecimal agreementPrice;

    public void setAgreementPrice() {
        this.agreementPrice = calculateDaysCount();
    }

    private BigDecimal calculateDaysCount() {
        long daysCount = this.agreementDateTo.getTime() - this.agreementDateFrom.getTime();
        long days = TimeUnit.DAYS.convert(daysCount, TimeUnit.MILLISECONDS);
        return new BigDecimal(days);
    }


}
