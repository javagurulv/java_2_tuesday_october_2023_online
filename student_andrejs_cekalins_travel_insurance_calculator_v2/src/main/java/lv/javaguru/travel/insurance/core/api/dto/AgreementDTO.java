package lv.javaguru.travel.insurance.core.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgreementDTO {
    private String uuid;

    private Date agreementDateFrom;

    private Date agreementDateTo;

    private String country;

    private List<String> selectedRisk;

    private List<PersonDTO> persons;

    private BigDecimal agreementPremium;
}
