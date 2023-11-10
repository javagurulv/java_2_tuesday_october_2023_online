package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.CoreError;

import java.util.*;

public class ClientOrderValidator {


private PersonalDateValidation personalDateValidation;
private PersonalSizeValidator personalSizeValidator;
private ComponentValidator componentValidator;

    public ClientOrderValidator(PersonalDateValidation personalDateValidation,
                                PersonalSizeValidator personalSizeValidator,
                                ComponentValidator componentValidator) {
        this.personalDateValidation = personalDateValidation;
        this.personalSizeValidator = personalSizeValidator;
        this.componentValidator = componentValidator;
    }

    public List<CoreError> validate(ClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalDate(request, errors);
        validatePersonSize(request, errors);
        validateComponent(request, errors);
        return errors;
    }



    private void validatePersonalDate(ClientRequest request, List<CoreError> errors) {
        errors.addAll(personalDateValidation
                .validate(request.getNameSurname(),
                        request.getPhoneNumber(),
                        request.getUserAddress()));

    }

    private void validatePersonSize(ClientRequest request, List<CoreError> errors) {
        errors.addAll(personalSizeValidator.validate(request.getPelvisWidth(),
                request.getThighLength(), request.getBackHeight(), request.getShinLength()));
    }

    private void validateComponent(ClientRequest request, List<CoreError> errors) {
        errors.addAll(componentValidator
                .validate(request.getIndexWheelFront(),
                        request.getIndexWheelBack(),
                        request.getIndexBrakeChoose(),
                        request.getIndexArmrestChoose()));

    }

}
