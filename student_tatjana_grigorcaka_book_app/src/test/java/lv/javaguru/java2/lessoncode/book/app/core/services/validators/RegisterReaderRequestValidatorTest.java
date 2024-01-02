package lv.javaguru.java2.lessoncode.book.app.core.services.validators;

import lv.javaguru.java2.lessoncode.book.app.core.database.BookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.ReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RegisterReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RegisterReaderRequestValidatorTest {

	@Mock private ReaderRepository readerRepository;
	@InjectMocks
	private RegisterReaderRequestValidator validator;



	@Test
	public void shouldReturnErrorWhenFirstNameIsNull() {
		RegisterReaderRequest request = new RegisterReaderRequest(null, "Smith", "312345-67891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getErrorCode(), "firstName");
		assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorWhenLastNameIsNull() {
		RegisterReaderRequest request = new RegisterReaderRequest("John", null, "312345-67891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getErrorCode(), "lastName");
		assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorWhenPersonaCodeIsNull() {
		RegisterReaderRequest request = new RegisterReaderRequest("John", "Smith", null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getErrorCode(), "personalCode");
		assertEquals(errors.get(0).getErrorMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorsWhenFirstNameAndLastNameAndPersonaCodeIsNull() {
		RegisterReaderRequest request = new RegisterReaderRequest(null, null, null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 3);
	}

	@Test
	public void shouldSuccess() {
		RegisterReaderRequest request = new RegisterReaderRequest("John", "Smith", "312345-67891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

	@Test
	public void shouldReturnErrorWhenDuplicateFound() {
		readerRepository = Mockito.mock(ReaderRepository.class);
		Mockito.when(readerRepository.findByFirstNameAndLastNameAndPersonalCode("John", "Smith", "312345-67891")).thenReturn(List.of(new Reader("John", "Smith", "312345-67891")));
		validator = new RegisterReaderRequestValidator(readerRepository);
		RegisterReaderRequest request = new RegisterReaderRequest("John", "Smith", "312345-67891");
		List<CoreError> errors = validator.validate(request);
		assertTrue(!errors.isEmpty());
		assertEquals(errors.get(0).getErrorCode(), "duplicate");
		assertEquals(errors.get(0).getErrorMessage(), "Duplicate reader not accepted!");
	}

	@Test
	public void shouldNotReturnErrorWhenDuplicateNotFound() {
		readerRepository = Mockito.mock(ReaderRepository.class);
		Mockito.when(readerRepository.findByFirstNameAndLastNameAndPersonalCode("John", "Smith", "312345-67891")).thenReturn(List.of());
		validator = new RegisterReaderRequestValidator(readerRepository);
		RegisterReaderRequest request = new RegisterReaderRequest("John", "Smith", "312345-67891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

}