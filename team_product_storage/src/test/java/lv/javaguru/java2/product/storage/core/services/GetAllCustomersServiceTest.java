package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.GetAllCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllCustomersResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class GetAllCustomersServiceTest {

    @Mock private JpaCustomerRepository customerRepository;
    @InjectMocks
    private GetAllCustomersService service;

    @Test
    public void shouldGetCustomersFromDb() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Store Akropole Alfa", "12345678910"));
        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        GetAllCustomersRequest request = new GetAllCustomersRequest();
        GetAllCustomersResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getCustomers().size(), 1);
        assertEquals(response.getCustomers().get(0).getCustomerName(), "Store Akropole Alfa");
        assertEquals(response.getCustomers().get(0).getRegistrationCode(), "12345678910");




    }


}