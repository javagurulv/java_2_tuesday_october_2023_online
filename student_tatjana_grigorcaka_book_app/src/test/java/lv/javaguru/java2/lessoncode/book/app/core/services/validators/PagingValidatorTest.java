package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;

public class PagingValidatorTest {
    private PagingValidator validator = new PagingValidator();

    @Test
    public void shouldReturnErrorWhenPageNumberContainNotValidValue() {
        Paging paging = new Paging(0, 1);
        List<CoreError> errors = validator.validate(paging);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageNumber");
        assertEquals(errors.get(0).getErrorMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeContainNotValidValue() {
        Paging paging = new Paging(1, 0);
        List<CoreError> errors = validator.validate(paging);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageSize");
        assertEquals(errors.get(0).getErrorMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberAreEmpty() {
        Paging paging = new Paging(null, 1);
        List<CoreError> errors = validator.validate(paging);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageNumber");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeAreEmpty() {
        Paging paging = new Paging(1, null);
        List<CoreError> errors = validator.validate(paging);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getErrorCode(), "pageSize");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
    }

}