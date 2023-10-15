package lv.javaguru.travel.insurance.rest;

import lombok.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelCalculatePremiumResponse {

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;
    BigDecimal agreementPrice = new BigDecimal(0);

}
