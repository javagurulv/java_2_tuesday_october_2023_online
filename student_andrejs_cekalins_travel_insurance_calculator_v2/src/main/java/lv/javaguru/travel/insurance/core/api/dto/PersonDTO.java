package lv.javaguru.travel.insurance.core.api.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    @Length(max = 200, message = "{First Name must be less than 200 symbols}")
    private String personFirstName;
    @Length(max = 200, message = "{Last Name must be less than 200 symbols}")
    private String personLastName;

    private String personCode;

    private Date personBirthDate;

    private String medicalRiskLimitLevel;

    private BigDecimal travelCost;

    private List<RiskDTO> risks;
}
