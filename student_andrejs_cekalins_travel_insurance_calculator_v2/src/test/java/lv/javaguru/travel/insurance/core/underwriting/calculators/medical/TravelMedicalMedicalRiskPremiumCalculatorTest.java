package lv.javaguru.travel.insurance.core.underwriting.calculators.medical;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelMedicalMedicalRiskPremiumCalculatorTest {
    @Mock
    private TravelMedicalAgeCoefficientCalculator ageCoefficientCalculator;
    @Mock
    private TravelMedicalCountryDefaultDayRateCalculator countryDefaultDayRateCalculator;
    @Mock
    private TravelMedicalDayCountCalculator dayCountCalculator;

    @Mock
    private TravelMedicalRiskLimitLevelCalculator riskLimitLevelCalculator;

    @InjectMocks
    private TravelMedicalRiskPremiumCalculator calculator;

    private AgreementDTO agreement;
    private PersonDTO person;

    @BeforeEach
    void setUp() {
        agreement = new AgreementDTO();
        person = new PersonDTO();
    }

    @Test
    void shouldCalculatePremiumCorrectly() {
        BigDecimal daysCount = BigDecimal.valueOf(10);
        BigDecimal countryDefaultRate = BigDecimal.valueOf(20);
        BigDecimal ageCoefficient = BigDecimal.valueOf(1.2);
        BigDecimal riskLimitLevel = BigDecimal.valueOf(1.0);

        when(dayCountCalculator.calculate(agreement)).thenReturn(daysCount);
        when(countryDefaultDayRateCalculator.calculate(agreement)).thenReturn(countryDefaultRate);
        when(ageCoefficientCalculator.calculate(person)).thenReturn(ageCoefficient);
        when(riskLimitLevelCalculator.calculate(person)).thenReturn(riskLimitLevel);

        BigDecimal expectedPremium = countryDefaultRate.multiply(daysCount).multiply(ageCoefficient)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal result = calculator.calculatePremium(agreement, person);

        assertEquals(expectedPremium, result);
    }
}