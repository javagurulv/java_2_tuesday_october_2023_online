package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class RemoveReaderRequestValidatorTest {

    private RemoveReaderRequestValidator validator = new RemoveReaderRequestValidator();

    @Test
    public void shouldReturnErrorWhenReaderIdIsNull() {
        RemoveReaderRequest request = new RemoveReaderRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "readerId");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        RemoveReaderRequest request = new RemoveReaderRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}