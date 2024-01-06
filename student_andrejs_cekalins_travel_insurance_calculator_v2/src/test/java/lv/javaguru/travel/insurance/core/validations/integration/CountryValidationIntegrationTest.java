package lv.javaguru.travel.insurance.core.validations.integration;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.validations.TravelAgreementValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static lv.javaguru.travel.insurance.core.api.dto.AgreementDTOBuilder.createAgreement;
import static lv.javaguru.travel.insurance.core.api.dto.PersonDTOBuilder.createPersonDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CountryValidationIntegrationTest {

    @Autowired private TravelAgreementValidator validator;

    @Test
    public void shouldReturnErrorWhenCountryIsNull() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry(null)
                .withSelectedRisks("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_10");
        assertEquals(errors.get(0).getDescription(), "Field country must not be empty!");
    }
    @Test
    public void shouldReturnErrorWhenCountryIsEmpty() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("")
                .withSelectedRisks("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_10");
        assertEquals(errors.get(0).getDescription(), "Field country must not be empty!");
    }
    @Test
    public void shouldReturnErrorWhenCountryNotSupported() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("NOT SUPPORTED")
                .withSelectedRisks("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_15");
        assertEquals(errors.get(0).getDescription(), "Country value = {NOT_SUPPORTED_COUNTRY} not supported!");
    }
    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
