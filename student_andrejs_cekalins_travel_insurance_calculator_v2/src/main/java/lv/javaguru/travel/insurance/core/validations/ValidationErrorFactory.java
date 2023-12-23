package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.util.ErrorCodeUtil;
import lv.javaguru.travel.insurance.core.util.Placeholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationErrorFactory {
    @Autowired
    private ErrorCodeUtil errorCodeUnit;

    public ValidationErrorDTO buildError(String errorCode) {
        String errorDescription = errorCodeUnit.getErrorDescription(errorCode);
        return new ValidationErrorDTO(errorCode, errorDescription);
    }
    public ValidationErrorDTO buildError(String errorCode, List<Placeholder> placeholders) {
        String errorDescription = errorCodeUnit.getErrorDescription(errorCode, placeholders);
        return  new ValidationErrorDTO(errorCode,errorDescription);
    }
}
