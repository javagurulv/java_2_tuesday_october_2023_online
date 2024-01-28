package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonalDateValidation {

    public List<CoreError> validate(UserRegistrationRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (surnameIsNull(request)) {
            errors.add(new CoreError("surname", "Must not be empty!"));
        }
        if(personalCodeIsNull(request)) {
            errors.add((new CoreError("personalCode", "Must not be empty!")));
        }
        if (isEmptyPhone(request)) {
            errors.add(new CoreError("phone", "Must not be empty!"));

        }
        if (addressIsNull(request)) {
            errors.add(new CoreError("address", "Must not be empty!"));
        }

        return errors;
    }

    private boolean surnameIsNull(UserRegistrationRequest request) {

        return (request.getNameSurname() == null || request.getNameSurname().equals(""));
    }

    private boolean personalCodeIsNull(UserRegistrationRequest request) {

        return (request.getPersonalCode() == null || request.getPersonalCode().equals(""));
    }

    private boolean isEmptyPhone(UserRegistrationRequest request) {
        return request.getPhoneNumber() == null || request.getPhoneNumber() <= 0;
    }

    private boolean addressIsNull(UserRegistrationRequest request)
    {
        return (request.getUserAddress() == null || request.getUserAddress().equals(""));
    }


}
