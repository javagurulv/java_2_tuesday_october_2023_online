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
public class RiskLimitLevelValidationIntegrationTest {

    @Autowired private TravelAgreementValidator validator;

   @Test
    public void shouldReturnErrorWhenMedicalRiskLimitLevelIsNull() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisk("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withPersonCode("11a11")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel(null)
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_13");
        assertEquals(errors.get(0).getDescription(), "Field medicalRiskLimitLevel must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenMedicalRiskLimitLevelIsEmpty() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisk("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withPersonCode("11a11")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_13");
        assertEquals(errors.get(0).getDescription(), "Field medicalRiskLimitLevel must not be empty!");
    }


    @Test
    public void shouldReturnErrorWhenMedicalRiskLimitLevelIsNotSupported() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisk("TRAVEL_MEDICAL")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withPersonCode("11a11")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("NOT SUPPORTED")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_14");
        assertEquals(errors.get(0).getDescription(), "MedicalRiskLimitLevel value = NOT SUPPORTED not supported!");
    }



    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
