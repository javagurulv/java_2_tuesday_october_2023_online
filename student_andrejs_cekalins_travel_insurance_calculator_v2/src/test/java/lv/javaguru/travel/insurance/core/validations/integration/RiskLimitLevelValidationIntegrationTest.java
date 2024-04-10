package lv.javaguru.travel.insurance.core.validations.integration;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.PersonDTO;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RiskLimitLevelValidationIntegrationTest {

    @Autowired private TravelAgreementValidator validator;

   @Test
    public void shouldReturnErrorWhenMedicalRiskLimitLevelIsNull() {
       AgreementDTO agreement = AgreementDTO.builder()
               .agreementDateFrom(createDate("28.12.2030"))
               .agreementDateTo(createDate("31.12.2052"))
               .country("SPAIN")
               .selectedRisks(List.of("TRAVEL_MEDICAL"))
               .persons(List.of(PersonDTO.builder()
                       .personFirstName("Vasja")
                       .personLastName("Pupkin")
                       .personCode("11a11")
                       .personBirthDate(createDate("01.01.1991"))
                       .medicalRiskLimitLevel(null)
                       .build()

               )).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_13");
        assertEquals(errors.get(0).getDescription(), "Field medicalRiskLimitLevel must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenMedicalRiskLimitLevelIsEmpty() {
        AgreementDTO agreement = AgreementDTO.builder()
                .agreementDateFrom(createDate("28.12.2030"))
                .agreementDateTo(createDate("31.12.2052"))
                .country("SPAIN")
                .selectedRisks(List.of("TRAVEL_MEDICAL"))
                .persons(List.of(PersonDTO.builder()
                        .personFirstName("Vasja")
                        .personLastName("Pupkin")
                        .personCode("11a11")
                        .personBirthDate(createDate("01.01.1991"))
                        .medicalRiskLimitLevel("")
                        .build()

                )).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_13");
        assertEquals(errors.get(0).getDescription(), "Field medicalRiskLimitLevel must not be empty!");
    }


    @Test
    public void shouldReturnErrorWhenMedicalRiskLimitLevelIsNotSupported() {
        AgreementDTO agreement = AgreementDTO.builder()
                .agreementDateFrom(createDate("28.12.2030"))
                .agreementDateTo(createDate("31.12.2052"))
                .country("SPAIN")
                .selectedRisks(List.of("TRAVEL_MEDICAL"))
                .persons(List.of(PersonDTO.builder()
                        .personFirstName("Vasja")
                        .personLastName("Pupkin")
                        .personCode("11a11")
                        .personBirthDate(createDate("01.01.1991"))
                        .medicalRiskLimitLevel("{NOT_SUPPORTED_MEDICAL_RISK_LIMIT_LEVEL}")
                        .build()

                )).build();
        List<ValidationErrorDTO> errors = validator.validate(agreement);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "ERROR_CODE_14");
        assertEquals(errors.get(0).getDescription(), "MedicalRiskLimitLevel value = {NOT_SUPPORTED_MEDICAL_RISK_LIMIT_LEVEL} not supported!");
    }



    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
