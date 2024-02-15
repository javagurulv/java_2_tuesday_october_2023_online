package lv.javaguru.travel.insurance.core.underwriting.calculators.cancellation;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.domain.TravelCancellationAgeCoefficient;
import lv.javaguru.travel.insurance.core.repositories.TravelCancellationAgeCoefficientRepository;

import lv.javaguru.travel.insurance.core.util.DateTimeUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TCAgeCoefficientCalculatorTest {
    @Mock
    private DateTimeUtil dateTimeUtil;
    @Mock
    private TravelCancellationAgeCoefficientRepository TCageCoefficientRepository;

    @InjectMocks
    private TravelCancellationAgeCoefficientCalculator calculator;

    private PersonDTO person;

    @BeforeEach
    void setUp() {
        person = new PersonDTO();
        person.setPersonBirthDate(Date.from(LocalDate.of(2000, 1, 1)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    @Test
    public void shouldFindCoefficientWhenTCAgeCoefficientExists() {
        LocalDate currentDate = LocalDate.of(2023, 12, 6);
        int age = 23;
        BigDecimal expectedCoefficient = BigDecimal.valueOf(1.2);

        when(dateTimeUtil.getCurrentDateTime()).thenReturn(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        TravelCancellationAgeCoefficient ageCoefficient = mock(TravelCancellationAgeCoefficient.class);
        when(ageCoefficient.getCoefficient()).thenReturn(expectedCoefficient);
        when(TCageCoefficientRepository.findCoefficient(age)).thenReturn(Optional.of(ageCoefficient));

        BigDecimal result = calculator.calculate(person);

        assertEquals(expectedCoefficient, result);
    }

    @Test
    void shouldThrowExceptionWhenTCAgeCoefficientNotFound() {
        LocalDate currentDate = LocalDate.of(2023, 12, 6);
        int age = 23;

        when(dateTimeUtil.getCurrentDateTime()).thenReturn(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        when(TCageCoefficientRepository.findCoefficient(age)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.calculate(person));

        assertEquals("Age coefficient not found for age = " + age, exception.getMessage());
    }
}