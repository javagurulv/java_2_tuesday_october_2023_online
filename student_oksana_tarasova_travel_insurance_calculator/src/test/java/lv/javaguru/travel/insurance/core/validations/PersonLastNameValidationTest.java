package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonLastNameValidationTest {

    @InjectMocks
    private PersonLastNameValidation validation;


    @Test
    void validatorLastName() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonLastName()).thenReturn("Ivanov");
        Optional<ValidationError> validLastName = validation.execute(request);
        assertEquals(validLastName, Optional.empty());

    }

    @Test
    void validatorLastNameIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonLastName()).thenReturn(null);
        Optional<ValidationError> validLastName = validation.execute(request);
        assertThat(validLastName).contains(new ValidationError("personLastName", "Must not be empty!"));

    }

    @Test
    void validatorLastNameIsEmpty() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonLastName()).thenReturn("");
        Optional<ValidationError> validLastName = validation.execute(request);
        assertThat(validLastName).contains(new ValidationError("personLastName", "Must not be empty!"));

    }

}