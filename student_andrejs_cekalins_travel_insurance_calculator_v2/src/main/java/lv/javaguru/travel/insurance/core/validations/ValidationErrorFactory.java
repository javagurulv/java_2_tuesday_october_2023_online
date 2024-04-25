package lv.javaguru.travel.insurance.core.validations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.util.ErrorCodeUtil;
import lv.javaguru.travel.insurance.core.util.Placeholder;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ValidationErrorFactory {

    private final ErrorCodeUtil errorCodeUnit;

    public ValidationErrorDTO buildError(String errorCode) {
        String errorDescription = errorCodeUnit.getErrorDescription(errorCode);
        return new ValidationErrorDTO(errorCode, errorDescription);
    }
    public ValidationErrorDTO buildError(String errorCode, List<Placeholder> placeholders) {
        String errorDescription = errorCodeUnit.getErrorDescription(errorCode, placeholders);
        return  new ValidationErrorDTO(errorCode,errorDescription);
    }
}
