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
public class SelectedRisksValidationIntegrationTest {

    @Autowired
    private TravelAgreementValidator validator;

    @Test
    public void shouldReturnErrorWhenAgreementSelectedRiskIsNull() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisk(null)
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_8");
        assertEquals(errors.get(0).getDescription(), "Field selectRisk must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenAgreementSelectedRiskIsEmpty() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisk("")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_8");
        assertEquals(errors.get(0).getDescription(), "Field selectRisk must not be empty!");
    }


   @Test
    public void shouldReturnErrorWhenAgreementSelectedRiskIsNotSupported() {
        AgreementDTO agreement = createAgreement()
                .withDateFrom(createDate("31.12.2032"))
                .withDateTo(createDate("31.12.2052"))
                .withCountry("SPAIN")
                .withSelectedRisks("{NOT_EXISTING_RISK_TYPE}")
                .withPerson(createPersonDTO()
                        .withFirstName("Vasja")
                        .withLastName("Pupkin")
                        .withBirthDate(createDate("01.01.1991"))
                        .withMedicalRiskLimitLevel("LEVEL_10000")
                ).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_9");
        assertEquals(errors.get(0).getDescription(), "Risk Type ic = {NOT_EXISTING_RISK_TYPE} not supported!");
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
