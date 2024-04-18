package lv.javaguru.travel.insurance.core.underwriting.calculators.medical;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.domain.TMAgeCoefficient;
import lv.javaguru.travel.insurance.core.repositories.TMAgeCoefficientRepository;
import lv.javaguru.travel.insurance.core.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Component
public class TMAgeCoefficientCalculator {

    @Value("${medical.risk.age.coefficient.enabled:false}")
    private Boolean medicalRiskAgeCoefficientEnabled;
    private final DateTimeUtil dateTimeUtil;
    private final TMAgeCoefficientRepository ageCoefficientRepository;

    public TMAgeCoefficientCalculator(DateTimeUtil dateTimeUtil,
                                      TMAgeCoefficientRepository ageCoefficientRepository) {
        this.dateTimeUtil = dateTimeUtil;
        this.ageCoefficientRepository = ageCoefficientRepository;
    }

    public BigDecimal calculate(PersonDTO person) {
        return medicalRiskAgeCoefficientEnabled
                ? getCoefficient(person)
                : getDefaultValue();
    }

    BigDecimal getCoefficient(PersonDTO person) {
        int age = calculateAge(person);
        return ageCoefficientRepository.findCoefficient(age)
                .map(TMAgeCoefficient::getCoefficient)
                .orElseThrow(() -> new RuntimeException("Age coefficient not found for age = " + age));
    }

    private Integer calculateAge(PersonDTO person) {
        LocalDate personBirthDate = toLocalDate(person.getPersonBirthDate());
        LocalDate currentDate = toLocalDate(dateTimeUtil.getCurrentDateTime());
        return Period.between(personBirthDate, currentDate).getYears();
    }

    private LocalDate toLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private static BigDecimal getDefaultValue() {
        return BigDecimal.ONE;
    }
}
