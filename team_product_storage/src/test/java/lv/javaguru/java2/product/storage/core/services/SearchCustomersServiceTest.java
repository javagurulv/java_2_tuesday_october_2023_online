package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.SearchCustomersResponse;
import lv.javaguru.java2.product.storage.core.services.validators.SearchCustomersRequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class SearchCustomersServiceTest {

    @Mock private JpaCustomerRepository customerRepository;
    @Mock private SearchCustomersRequestValidator validator;
    @InjectMocks
    private SearchCustomersService service;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(service, "orderingEnabled", true);
        ReflectionTestUtils.setField(service, "pagingEnabled", true);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchCustomersRequest request = new SearchCustomersRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("customerName", "Must not be empty!"));
        errors.add(new CoreError("registrationCode", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchCustomersResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(customerRepository);
    }

    @Test
    public void shouldSearchByCustomerName() {
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "123456A"));
        Mockito.when(customerRepository.findByCustomerNameLike("Store Akropole Alfa")).thenReturn(customers);

        SearchCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 1);
        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "123456A");

    }

    @Test
    public void shouldSearchByRegistrationCode() {
        SearchCustomersRequest request = new SearchCustomersRequest(null, "123456A");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "123456A"));
        Mockito.when(customerRepository.findByRegistrationCodeLike("123456A")).thenReturn(customers);

        SearchCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 1);
        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "123456A");

    }

    @Test
    public void shouldSearchByCustomerNameAndRegistrationCode() {
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", "123456A");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "123456A"));
        Mockito.when(customerRepository.findByCustomerNameAndRegistrationCodeLike("Store Akropole Alfa", "123456A")).thenReturn(customers);

        SearchCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 1);
        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "123456A");

    }

    @Test
    public void shouldSearchByCustomerNameWithOrderingAscending() {
        Ordering ordering = new Ordering("registrationNumber", "ASCENDING");
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "123456A"));
        customers.add(new Customer("Store Akropole Alfa", "123456B"));
        Mockito.when(customerRepository.findByCustomerNameLike("Store Akropole Alfa")).thenReturn(customers);

        SearchCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 2);

        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "123456A");

        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(1).getRegistrationCode(), "123456B");

    }

    @Test
    public void shouldSearchByCustomerNameWithOrderingDescending() {
        Ordering ordering = new Ordering("registrationNumber", "DESCENDING");
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "123456A"));
        customers.add(new Customer("Store Akropole Alfa", "123456B"));
        Mockito.when(customerRepository.findByCustomerNameLike("Store Akropole Alfa")).thenReturn(customers);

        SearchCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 2);
        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "123456B");

        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(1).getRegistrationCode(), "123456A");



    }

    @Test
    public void shouldSearchByCustomerNameWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "123456A"));
        customers.add(new Customer("Store Akropole Alfa", "123456B"));
        Mockito.when(customerRepository.findByCustomerNameLike("Store Akropole Alfa")).thenReturn(customers);

        SearchCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 1);
        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "123456A");

    }

    @Test
    public void shouldSearchByCustomerNameWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchCustomersRequest request = new SearchCustomersRequest("Store Akropole Alfa", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "123456A"));
        customers.add(new Customer("Store Akropole Alfa", "123456B"));
        Mockito.when(customerRepository.findByCustomerNameLike("Store Akropole Alfa")).thenReturn(customers);

        SearchCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 1);
        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "123456B");

    }

}