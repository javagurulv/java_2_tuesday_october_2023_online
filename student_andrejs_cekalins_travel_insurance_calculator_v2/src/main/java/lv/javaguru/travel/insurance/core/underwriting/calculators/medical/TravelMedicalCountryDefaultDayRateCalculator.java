package lv.javaguru.travel.insurance.core.underwriting.calculators.medical;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.domain.TravelMedicalCountryDefaultDayRate;
import lv.javaguru.travel.insurance.core.repositories.TravelMedicalCountryDefaultDayRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TravelMedicalCountryDefaultDayRateCalculator {
    @Autowired
    private TravelMedicalCountryDefaultDayRateRepository countryDefaultDayRateRepository;

    public BigDecimal calculate(AgreementDTO agreement) {
        return countryDefaultDayRateRepository.findByCountryIc(agreement.getCountry())
                .map(TravelMedicalCountryDefaultDayRate::getDefaultDayRate)
                .orElseThrow(() -> new RuntimeException("Country day rate not found by country id = " + agreement.getCountry()));
    }
}