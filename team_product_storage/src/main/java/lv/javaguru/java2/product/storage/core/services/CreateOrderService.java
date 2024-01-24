package lv.javaguru.java2.product.storage.core.services;


import lv.javaguru.java2.product.storage.core.domain.Customer;

import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.requests.CreateOrderRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.CreateOrderResponse;
import lv.javaguru.java2.product.storage.core.services.validators.CreateOrderRequestValidator;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class CreateOrderService {

    @Autowired private CreateOrderRequestValidator validator;
    @Autowired private JpaCustomerRepository customerRepository;
    @Autowired private JpaOrderRepository orderRepository;


    public CreateOrderResponse execute(CreateOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new CreateOrderResponse(errors);
        }

        Customer customer = customerRepository.getReferenceById(request.getCustomerId());

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(new Date());

        orderRepository.save(order);

        return new CreateOrderResponse(null);
    }

}
