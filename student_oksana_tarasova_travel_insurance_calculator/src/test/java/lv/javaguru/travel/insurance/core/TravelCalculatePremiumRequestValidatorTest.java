package lv.javaguru.travel.insurance.core;


import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TravelCalculatePremiumRequestValidatorTest {

    TravelCalculatePremiumRequestValidator validator = new TravelCalculatePremiumRequestValidator();


    @Test
    void validatorFirstName() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                dateTo);
        List<ValidationError> validFirstName = validator.validate(request);
        List<ValidationError> expected = new ArrayList<>();
        assertEquals(expected, validFirstName);
    }

    @Test
    void validatorFirstNameIsNull() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, "Ivanov", dateFrom,
                dateTo);
        List<ValidationError> validFirstName = validator.validate(request);
        assertThat(validFirstName).contains(new ValidationError("personFirstName", "Must not be empty!"));

    }

    @Test
    void validatorFirstNameIsEmpty() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "", "Ivanov", dateFrom,
                dateTo);
        List<ValidationError> validFirstName = validator.validate(request);
        assertThat(validFirstName).contains(new ValidationError("personFirstName", "Must not be empty!"));

    }

    @Test
    void validatorLastNameIsNull() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", null, dateFrom,
                dateTo);
        List<ValidationError> validLastName = validator.validate(request);
        assertThat(validLastName).contains(new ValidationError("personLastName", "Must not be empty!"));

    }

    @Test
    void validatorLastNameIsEmpty() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "", dateFrom,
                dateTo);
        List<ValidationError> validLastName = validator.validate(request);
        assertThat(validLastName).contains(new ValidationError("personLastName", "Must not be empty!"));

    }

    @Test
    void validatorFirstNameAndLastNameIsEmpty() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "", "", dateFrom,
                dateTo);
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).hasSize(2);
        assertThat(validList).contains(new ValidationError("personFirstName", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("personLastName", "Must not be empty!"));
    }

    @Test
    void validatorDateFromIsNull() throws ParseException {

        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2000");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", null,
                dateTo);
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).contains(new ValidationError("agreementDateFrom", "Must not be empty!"));

    }

    @Test
    void validatorDateToIsNull() throws ParseException {
        Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");

        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan", "Ivanov", dateFrom,
                null);
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).contains(new ValidationError("agreementDateTo", "Must not be empty!"));

    }

    @Test
    void validatorAllNamesAndAllDateIsNull() throws ParseException {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, null, null,
                null);
        List<ValidationError> validList = validator.validate(request);
        assertThat(validList).hasSize(4);
        assertThat(validList).contains(new ValidationError("personFirstName", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("personLastName", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("agreementDateFrom", "Must not be empty!"));
        assertThat(validList).contains(new ValidationError("agreementDateTo", "Must not be empty!"));

    }

}