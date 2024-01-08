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
public class AgreementDateFromValidationIntegrationTest {

    @Autowired private TravelAgreementValidator validator;

    @Test
    public void shouldReturnErrorWhenDateFromIsNull() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(null)
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisks("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withPersonCode("11a11")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_3");
        assertEquals(errors.get(0).getDescription(), "Field agreementDateFrom must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenDateFromIsInThePast() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2022"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisks("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withPersonCode("11a11")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_4");
        assertEquals(errors.get(0).getDescription(), "Field agreementDayFrom must be in the future!");
    }


    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
