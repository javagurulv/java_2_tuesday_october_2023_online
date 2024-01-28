package fitness_club.core.services.validators;

import fitness_club.core.requests.SearchClientsRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.client.SearchClientsRequestValidator;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class SearchClientRequestFieldValidatorTest {


    private SearchClientsRequestValidator validator = new SearchClientsRequestValidator ();

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

}
