package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonalDateValidationTest {


    private PersonalDateValidation personalDateValidation;


    @Test
    public void surnameIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        UserRegistrationRequest request = new UserRegistrationRequest(null,11111l, 343434l,"Lesnaja, 22");
        List<CoreError> errors = personalDateValidation.validate(request);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!")));
    }

    @Test
    public void phoneIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        UserRegistrationRequest request = new UserRegistrationRequest("Ivanov",11111l, null,"Lesnaja, 22");
        List<CoreError> errors = personalDateValidation.validate(request);
        assertEquals(errors, List.of(new CoreError("phone", "Must not be empty!")));
    }

    @Test
    public void addressIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        UserRegistrationRequest request = new UserRegistrationRequest("Ivanov",11111l, 343434l,"");
        List<CoreError> errors = personalDateValidation.validate(request);
        assertEquals(errors, List.of(new CoreError("address", "Must not be empty!")));
    }

    @Test
    public void SurnameAndAddressAreEmpty() {
        personalDateValidation = new PersonalDateValidation();
        UserRegistrationRequest request = new UserRegistrationRequest("",11111l, 343434l,"");
        List<CoreError> errors = personalDateValidation.validate(request);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!"),
                new CoreError("address", "Must not be empty!")));
    }

    @Test
    public void SurnameAndAddressAndPhoneAreEmpty() {
        personalDateValidation = new PersonalDateValidation();
        UserRegistrationRequest request = new UserRegistrationRequest(null,11111l, null,"");
        List<CoreError> errors = personalDateValidation.validate(request);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!"),
                new CoreError("phone", "Must not be empty!"),
                new CoreError("address", "Must not be empty!")));
    }


}