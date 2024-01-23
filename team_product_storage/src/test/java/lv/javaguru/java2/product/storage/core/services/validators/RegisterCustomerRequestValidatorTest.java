package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.RegisterCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
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
public class RegisterCustomerRequestValidatorTest {

	@Mock private JpaCustomerRepository customerRepository;
	@InjectMocks
	private RegisterCustomerRequestValidator validator;



	@Test
	public void shouldReturnErrorWhenCustomerNameIsNull() {
		RegisterCustomerRequest request = new RegisterCustomerRequest(null, "12345678910");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getErrorCode(), "customerName");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorWhenRegistrationCodeIsNull() {
		RegisterCustomerRequest request = new RegisterCustomerRequest("Store Akropole Alfa", null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 1);
		assertEquals(errors.get(0).getErrorCode(), "registrationCode");
		assertEquals(errors.get(0).getMessage(), "Must not be empty!");
	}

	@Test
	public void shouldReturnErrorsWhenCustomerNameAndRegistrationodeIsNull() {
		RegisterCustomerRequest request = new RegisterCustomerRequest(null, null);
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 2);
	}

	@Test
	public void shouldSuccess() {
		RegisterCustomerRequest request = new RegisterCustomerRequest("Store Akropole Alfa", "12345678910");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

	@Test
	public void shouldReturnErrorWhenDuplicateFound() {
		customerRepository = Mockito.mock(JpaCustomerRepository.class);
		Mockito.when(customerRepository.findByCustomerNameAndRegistrationCode("Store Akropole Alfa", "12345678910")).thenReturn(List.of(new Customer("Store Akropole Alfa", "12345678910")));
		validator = new RegisterCustomerRequestValidator(customerRepository);
		RegisterCustomerRequest request = new RegisterCustomerRequest("Store Akropole Alfa", "12345678910");
		List<CoreError> errors = validator.validate(request);
		assertTrue(!errors.isEmpty());
		assertEquals(errors.get(0).getErrorCode(), "duplicate");
		assertEquals(errors.get(0).getMessage(), "Duplicate customer not accepted!");
	}

	@Test
	public void shouldNotReturnErrorWhenDuplicateNotFound() {
		customerRepository = Mockito.mock(JpaCustomerRepository.class);
		Mockito.when(customerRepository.findByCustomerNameAndRegistrationCode("Store Akropole Alfa", "12345678910")).thenReturn(List.of());
		validator = new RegisterCustomerRequestValidator(customerRepository);
		RegisterCustomerRequest request = new RegisterCustomerRequest("Store Akropole Alfa", "12345678910");
		List<CoreError> errors = validator.validate(request);
		assertEquals(errors.size(), 0);
	}

}