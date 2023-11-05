package lv.javaguru.travel.insurance.core;


import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumRequestValidatorTest {
    @Mock private DateTimeService dateTimeService;

    @InjectMocks
    private TravelCalculatePremiumRequestValidator validator;


    @Test
    void validatorFirstName() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validFirstName = validator.validate(request);
        List<ValidationError> expected = List.of();
        assertEquals(expected, validFirstName);
    }

    @Test
    void validatorFirstNameIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn(null);
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validFirstName = validator.validate(request);
        assertThat(validFirstName).contains(new ValidationError("personFirstName", "Must not be empty!"));

    }

    @Test
    void validatorFirstNameIsEmpty() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("");
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validFirstName = validator.validate(request);
        assertThat(validFirstName).contains(new ValidationError("personFirstName", "Must not be empty!"));

    }

    @Test
    void validatorLastNameIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn(null);
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validLastName = validator.validate(request);
        assertThat(validLastName).contains(new ValidationError("personLastName", "Must not be empty!"));

    }

    @Test
    void validatorLastNameIsEmpty() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn("");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validLastName = validator.validate(request);
        assertThat(validLastName).contains(new ValidationError("personLastName", "Must not be empty!"));

    }

    @Test
    void validatorFirstNameAndLastNameIsEmpty() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("");
        when(request.getPersonLastName()).thenReturn("");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).hasSize(2);
        assertThat(validList).contains(new ValidationError("personFirstName", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("personLastName", "Must not be empty!"));
    }

    @Test
    void validatorDateFromIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(null);
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).contains(new ValidationError("agreementDateFrom", "Must not be empty!"));

    }

    @Test
    void validatorDateToIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(null);
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).contains(new ValidationError("agreementDateTo", "Must not be empty!"));

    }


    @Test
    void validatorAllNamesAndAllDateIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn(null);
        when(request.getPersonLastName()).thenReturn(null);
        when(request.getAgreementDateFrom()).thenReturn(null);
        when(request.getAgreementDateTo()).thenReturn(null);
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).hasSize(4);
        assertThat(validList).contains(new ValidationError("personFirstName", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("personLastName", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("agreementDateFrom", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("agreementDateTo", "Must not be empty!"));

    }

    @Test
    void validateDateFromIsLessDateTo() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.06.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validFirstName = validator.validate(request);
        ValidationError expected = (new ValidationError("agreementDateFrom", "Must be less than the agreementDateTo!"));
        assertThat(validFirstName).contains(expected);
    }

    @Test
    void validatorDateFromIsFuture() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2022"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2024"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validFirstName = validator.validate(request);
        ValidationError expected = (new ValidationError("agreementDateFrom", "Must be in the future!"));
        assertThat(validFirstName).contains(expected);


    }


    @Test
    void validatorDateToIsFuture() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("Ivan");
        when(request.getPersonLastName()).thenReturn("Ivanov");
        when(request.getAgreementDateFrom()).thenReturn(createDate("01.05.2024"));
        when(request.getAgreementDateTo()).thenReturn(createDate("16.05.2022"));
        when(dateTimeService.getCurrentDateTime()).thenReturn(createDate("17.05.2023"));
        List<ValidationError> validFirstName = validator.validate(request);
        ValidationError expected = (new ValidationError("agreementDateTo", "Must be in the future!"));
        assertThat(validFirstName).contains(expected);

    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}