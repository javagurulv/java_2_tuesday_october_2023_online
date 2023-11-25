package fitness_club.core.services.data_vlidation;

import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.CoreError;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class SearchClientRequestFieldValidatorTest {


    private SearchClientRequestFieldValidator validator = new SearchClientRequestFieldValidator();

    @Test
    public void shouldNotReturnErrorsWhenFirstNameIsProvided() {
        SearchClientRequest request = new SearchClientRequest("FirstName", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenLastNameIsProvided() {
        SearchClientRequest request = new SearchClientRequest(null, "LastName");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenFirstNameAndLastNameIsProvided() {
        SearchClientRequest request = new SearchClientRequest("FirstName", "LastName");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchClientRequest request = new SearchClientRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "lastName");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }
}
