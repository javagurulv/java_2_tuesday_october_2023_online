package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;

import java.util.ArrayList;
import java.util.List;

public class PersonalDateValidation {

    public List<CoreError> validate(String surname, Integer phone, String address) {
        List<CoreError> errors = new ArrayList<>();
        if (surnameIsNull(surname)) {
            errors.add(new CoreError("surname", "Must not be empty!"));
        }
        if (isEmptyPhone(phone)) {
            errors.add(new CoreError("phone", "Must not be empty!"));

        }
        if (addressIsNull(address)) {
            errors.add(new CoreError("address", "Must not be empty!"));
        }

        return errors;
    }

    private boolean surnameIsNull(String surname) {
        return (surname == null || surname.equals(""));
    }

    private boolean isEmptyPhone(Integer phone) {
        return phone == null || phone <= 0;
    }

    private boolean addressIsNull(String address) {
        return (address == null || address.equals(""));
    }
}
