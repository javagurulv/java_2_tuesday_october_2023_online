package fitness_club.core.services.validators;

import fitness_club.core.requests.SearchClientsRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.client.SearchClientsRequestFieldValidator;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class SearchClientRequestFieldValidatorTest {


    private SearchClientsRequestFieldValidator validator = new SearchClientsRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenFirstNameIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest("FirstName", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenLastNameIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest(null, "LastName");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
    @Test
    public void shouldNotReturnErrorsWhenPersonalCodeIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest(null, "PersonalCode");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenFirstNameAndLastNameIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenFirstNameLastNamePersonalCodeIsProvided() {
        SearchClientsRequest request = new SearchClientsRequest("FirstName", "LastName", "PersonalCode");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchClientsRequest request = new SearchClientsRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 3);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "lastName");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
        assertEquals(errors.get(2).getField(), "personalCode");
        assertEquals(errors.get(2).getMessage(), "Must not be empty!");

    }
}
