package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonalDateValidationTest {

    private PersonalDateValidation personalDateValidation;

    @Test
    public void surnameIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        String surname = null;
        Integer phone = 343434;
        String address = "Lesnaja, 22";
        List<CoreError> errors = personalDateValidation.validate(surname, phone, address);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!")));
    }
    @Test
    public void phoneIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        String surname = "Ivanov";
        Integer phone = null;
        String address = "Lesnaja, 22";
        List<CoreError> errors = personalDateValidation.validate(surname, phone, address);
        assertEquals(errors, List.of(new CoreError("phone", "Must not be empty!")));
    }
    @Test
    public void addressIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        String surname = "Ivanov";
        Integer phone =1234567;
        String address = "";
        List<CoreError> errors = personalDateValidation.validate(surname, phone, address);
        assertEquals(errors, List.of(new CoreError("address", "Must not be empty!")));
    }
    @Test
    public void SurnameAndAddressAreEmpty() {
        personalDateValidation = new PersonalDateValidation();
        String surname = "";
        Integer phone =1234567;
        String address = "";
        List<CoreError> errors = personalDateValidation.validate(surname, phone, address);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!"),
                new CoreError("address", "Must not be empty!")));
    }

    @Test
    public void SurnameAndAddressAndPhoneAreEmpty() {
        personalDateValidation = new PersonalDateValidation();
        String surname = "";
        Integer phone = 0;
        String address = "";
        List<CoreError> errors = personalDateValidation.validate(surname, phone, address);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!"),
                new CoreError("phone", "Must not be empty!"),
                new CoreError("address", "Must not be empty!")));
    }


}