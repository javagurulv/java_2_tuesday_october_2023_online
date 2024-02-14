package lv.javaguru.travel.insurance.core.underwriting.calculators.cancellation;

import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.core.domain.TravelCancellationTravelCostCoefficient;
import lv.javaguru.travel.insurance.core.repositories.TravelCancellationTravelCostCoefficientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TCTravelCostCoefficientCalculatorTest {

    @Mock
    private TravelCancellationTravelCostCoefficientRepository TCTravelCostCoefficientRepository;
    @InjectMocks
    private TravelCostCoefficientCalculator calculator;

    private PersonDTO person;

    @BeforeEach
    void setUp() {
        person = new PersonDTO();
        person.setTravelCost(BigDecimal.ONE);
    }

    @Test
    void shouldFindCoefficientWhenAgeCoefficientExists() {
        TravelCancellationTravelCostCoefficient TCTravelCostCoefficient = mock(TravelCancellationTravelCostCoefficient.class);
        when(TCTravelCostCoefficient.getCoefficient()).thenReturn(BigDecimal.TEN);
        when(TCTravelCostCoefficientRepository.findCoefficient(BigDecimal.ONE)).thenReturn(Optional.of(TCTravelCostCoefficient));

        BigDecimal result = calculator.calculate(person);

        assertEquals(BigDecimal.TEN, result);
    }

    @Test
    void shouldThrowExceptionWhenTravelCostCoefficientNotFound() {
        when(TCTravelCostCoefficientRepository.findCoefficient(BigDecimal.ONE)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.calculate(person));
        assertEquals("Travel Cost coefficient not found for travel cost = " + BigDecimal.ONE, exception.getMessage());
    }

}
