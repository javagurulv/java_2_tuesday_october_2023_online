package lv.javaguru.travel.insurance.core.api.comamnd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TravelGetAllAgreementUuidsCoreResult {

    private List<ValidationErrorDTO> errors;

    private List<String> AgreementUuids;

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }

    public TravelGetAllAgreementUuidsCoreResult(List<ValidationErrorDTO> errors) {this.errors = errors;}
}
