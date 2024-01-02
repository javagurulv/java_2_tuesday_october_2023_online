package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonalDateValidation {

    public List<CoreError> validate(Client userRegistration) {
        List<CoreError> errors = new ArrayList<>();
        if (surnameIsNull(userRegistration)) {
            errors.add(new CoreError("surname", "Must not be empty!"));
        }
        if(personalCodeIsNull(userRegistration)) {
            errors.add((new CoreError("personalCode", "Must not be empty!")));
        }
        if (isEmptyPhone(userRegistration)) {
            errors.add(new CoreError("phone", "Must not be empty!"));

        }
        if (addressIsNull(userRegistration)) {
            errors.add(new CoreError("address", "Must not be empty!"));
        }

        return errors;
    }

    private boolean surnameIsNull(Client userRegistration) {

        return (userRegistration.getNameSurname() == null || userRegistration.getNameSurname().equals(""));
    }

    private boolean personalCodeIsNull(Client userRegistration) {

        return (userRegistration.getPersonalCode() == null || userRegistration.getPersonalCode().equals(""));
    }

    private boolean isEmptyPhone(Client userRegistration) {
        return userRegistration.getPhone() == null || userRegistration.getPhone() <= 0;
    }

    private boolean addressIsNull(Client userRegistration)
    {
        return (userRegistration.getAddress() == null || userRegistration.getAddress().equals(""));
    }


}
