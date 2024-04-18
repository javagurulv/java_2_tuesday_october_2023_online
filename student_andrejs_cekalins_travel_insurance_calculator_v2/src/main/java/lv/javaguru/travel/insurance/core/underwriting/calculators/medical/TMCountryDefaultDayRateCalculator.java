package lv.javaguru.travel.insurance.core.underwriting.calculators.medical;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.domain.TMCountryDefaultDayRate;
import lv.javaguru.travel.insurance.core.repositories.TMCountryDefaultDayRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TMCountryDefaultDayRateCalculator {
    private final TMCountryDefaultDayRateRepository countryDefaultDayRateRepository;

    public BigDecimal calculate(AgreementDTO agreement) {
        return countryDefaultDayRateRepository.findByCountryIc(agreement.getCountry())
                .map(TMCountryDefaultDayRate::getDefaultDayRate)
                .orElseThrow(() -> new RuntimeException("Country day rate not found by country id = " + agreement.getCountry()));
    }
}
