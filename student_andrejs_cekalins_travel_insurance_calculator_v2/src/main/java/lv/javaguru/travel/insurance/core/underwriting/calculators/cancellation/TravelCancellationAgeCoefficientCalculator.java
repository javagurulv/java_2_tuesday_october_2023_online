package lv.javaguru.travel.insurance.core.underwriting.calculators.cancellation;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.domain.TravelCancellationAgeCoefficient;
import lv.javaguru.travel.insurance.core.domain.TravelMedicalAgeCoefficient;
import lv.javaguru.travel.insurance.core.repositories.TravelCancellationAgeCoefficientRepository;
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
public class TravelCancellationAgeCoefficientCalculator {

    @Autowired
    private DateTimeUtil dateTimeUtil;
    @Autowired
    private TravelCancellationAgeCoefficientRepository TCAgeCoefficientRepository;

    public BigDecimal calculate(PersonDTO person) {
        int age = calculateAge(person);
        return TCAgeCoefficientRepository.findCoefficient(age)
                .map(TravelCancellationAgeCoefficient::getCoefficient)
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
}
