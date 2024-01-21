package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RegisterReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RegisterReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.RegisterReaderRequestValidator;
import lv.javaguru.java2.lessoncode.book.app.matchers.ReaderMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegisterReaderServiceTest {

    @Mock private JpaReaderRepository readerRepository;
    @Mock private RegisterReaderRequestValidator validator;
    @InjectMocks
    private RegisterReaderService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenFirstNameIsEmpty() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest(null, "Smith", "312345-67891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("firstName", "Must not be empty!")));
        RegisterReaderResponse response = service.execute(notValidRequest);
        assertTrue(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenFirstNameIsEmpty() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest( null, "Smith", "312345-67891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("firstName", "Must not be empty!")));
        RegisterReaderResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "firstName");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenFirstNameIsEmpty() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest(null, "Smith", "312345-67891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("firstName", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(readerRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenLastNameIsEmpty() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest("John", null, "312345-67891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("lastName", "Must not be empty!")));
        RegisterReaderResponse response = service.execute(notValidRequest);
        assertTrue(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenLastNameIsEmpty() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest("John", null, "312345-67891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("lastName", "Must not be empty!")));
        RegisterReaderResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "lastName");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenLastNameIsEmpty() {
        RegisterReaderRequest notValidRequest = new  RegisterReaderRequest("John", null, "312345-67891");
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("lastName", "Must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(readerRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFailsWhenPersonalCodeIsNull() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest("John", "Smith", null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode", "Must not be empty!")));
        RegisterReaderResponse response = service.execute(notValidRequest);
        assertTrue(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidatorWhenPersonalCodeIsNull() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest("John", "Smith", null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode", "Must not be empty!")));
        RegisterReaderResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "personalCode");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFailsWhenPersonasCodeIsNull() {
        RegisterReaderRequest notValidRequest = new RegisterReaderRequest("John", "John", null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode", "Must not be empty")));
        service.execute(notValidRequest);
        verifyNoInteractions(readerRepository);
    }


    @Test
    public void shouldRegisterReaderToDatabaseWhenRequestIsValid() {
        RegisterReaderRequest validRequest = new RegisterReaderRequest("John", "Smith", "312345-67891");
        when(validator.validate(validRequest)).thenReturn(List.of());
        service.execute(validRequest);
        verify(readerRepository).save(argThat(new ReaderMatcher("John", "Smith", "312345-67891")));
    }

    @Test
    public void shouldReturnResponseWithoutErrorsWhenRequestIsValid() {
        RegisterReaderRequest validRequest = new RegisterReaderRequest("John", "Smith", "312345-67891");
        when(validator.validate(validRequest)).thenReturn(List.of());
        RegisterReaderResponse response = service.execute(validRequest);
        assertFalse(response.containsErrors());
    }

    @Test
    public void shouldReturnResponseWithBookWhenRequestIsValid() {
        RegisterReaderRequest validRequest = new RegisterReaderRequest("John", "Smith", "312345-67891");
        when(validator.validate(validRequest)).thenReturn(List.of());
        RegisterReaderResponse response = service.execute(validRequest);
        assertNotNull(response.getNewReader());
        assertEquals(response.getNewReader().getFirstName(), validRequest.getFirstName());
        assertEquals(response.getNewReader().getLastName(), validRequest.getLastName());
        assertEquals(response.getNewReader().getPersonalCode(), validRequest.getPersonalCode());
    }
}