package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonalDateValidationTest {


    private PersonalDateValidation personalDateValidation;


    @Test
    public void surnameIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        Client client = new Client();
        client.setNameSurname(null);
        client.setPersonalCode(11111l);
        client.setPhone(343434l);
        client.setAddress("Lesnaja, 22");
        List<CoreError> errors = personalDateValidation.validate(client);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!")));
    }

    @Test
    public void phoneIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        Client client = new Client();
        client.setNameSurname("Ivanov");
        client.setPersonalCode(11111l);
        client.setPhone(null);
        client.setAddress("Lesnaja, 22");
        List<CoreError> errors = personalDateValidation.validate(client);
        assertEquals(errors, List.of(new CoreError("phone", "Must not be empty!")));
    }

    @Test
    public void addressIsEmpty() {
        personalDateValidation = new PersonalDateValidation();
        Client client = new Client();
        client.setNameSurname("Ivanov");
        client.setPersonalCode(11111l);
        client.setPhone(343434l);
        client.setAddress("");
        List<CoreError> errors = personalDateValidation.validate(client);
        assertEquals(errors, List.of(new CoreError("address", "Must not be empty!")));
    }

    @Test
    public void SurnameAndAddressAreEmpty() {
        personalDateValidation = new PersonalDateValidation();
        Client client = new Client();
        client.setNameSurname("");
        client.setPersonalCode(11111l);
        client.setPhone(343434l);
        client.setAddress("");
        List<CoreError> errors = personalDateValidation.validate(client);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!"),
                new CoreError("address", "Must not be empty!")));
    }

    @Test
    public void SurnameAndAddressAndPhoneAreEmpty() {
        personalDateValidation = new PersonalDateValidation();
        Client client = new Client();
        client.setNameSurname(null);
        client.setPersonalCode(11111l);
        client.setPhone(null);
        client.setAddress("");
        List<CoreError> errors = personalDateValidation.validate(client);
        assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!"),
                new CoreError("phone", "Must not be empty!"),
                new CoreError("address", "Must not be empty!")));
    }


}