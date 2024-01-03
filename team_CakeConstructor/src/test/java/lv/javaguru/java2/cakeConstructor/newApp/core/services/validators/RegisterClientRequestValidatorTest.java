package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.ClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RegisterClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
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
public class RegisterClientRequestValidatorTest {

	@Mock private ClientRepository userRepository;
	@InjectMocks
	private RegisterClientRequestValidator validator;



	@Test
	public void shouldReturnErrorWhenFirstNameIsNull() {
		RegisterClientRequest request = new RegisterClientRequest(null, "Muller", "31234567891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getField(), "firstName");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorWhenLastNameIsNull() {
		RegisterClientRequest request = new RegisterClientRequest("Liza", null, "31234567891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getField(), "lastName");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorWhenPersonaCodeIsNull() {
		RegisterClientRequest request = new RegisterClientRequest("Liza", "Muller", null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getField(), "personalCode");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorsWhenFirstNameAndLastNameAndPersonaCodeIsNull() {
		RegisterClientRequest request = new RegisterClientRequest(null, null, null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 3);
	}

	@Test
	public void shouldSuccess() {
		RegisterClientRequest request = new RegisterClientRequest("Liza", "Muller", "31234567891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

	@Test
	public void shouldReturnErrorWhenDuplicateFound() {
		userRepository = Mockito.mock(ClientRepository.class);
		Mockito.when(userRepository.findByFirstNameAndLastNameAndPersonalCode("Liza", "Muller", "31234567891")).thenReturn(List.of(new Client("Liza", "Muller", "31234567891")));
		validator = new RegisterClientRequestValidator(userRepository);
		RegisterClientRequest request = new RegisterClientRequest("Liza", "Muller", "31234567891");
		List<CoreError> errors = validator.validate(request);
		assertTrue(!errors.isEmpty());
		assertEquals(errors.get(0).getField(), "duplicate");
		assertEquals(errors.get(0).getMessage(), "Duplicate user not accepted!");
	}

	@Test
	public void shouldNotReturnErrorWhenDuplicateNotFound() {
		userRepository = Mockito.mock(ClientRepository.class);
		Mockito.when(userRepository.findByFirstNameAndLastNameAndPersonalCode("Liza", "Muller", "31234567891")).thenReturn(List.of());
		validator = new RegisterClientRequestValidator(userRepository);
		RegisterClientRequest request = new RegisterClientRequest("Liza", "Muller", "31234567891");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

}