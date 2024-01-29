package lv.javaguru.java2.cakeConstructor.newApp.core.services;


import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Order;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.CreateOrderRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CreateOrderResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.CreateOrderRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class CreateOrderService {

    @Autowired private CreateOrderRequestValidator validator;
    @Autowired private JpaClientRepository clientRepository;
    @Autowired private JpaOrderRepository orderRepository;
    @Autowired private JpaCakeRepository cakeRepository;


    public CreateOrderResponse execute(CreateOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new CreateOrderResponse(errors);
        }

        Client client = clientRepository.getReferenceById(request.getClientId());
        Cake cake = cakeRepository.getReferenceById(request.getCakeId());

        Order order = new Order();
        order.setClient(client);
        order.setCake(cake);
        order.setOrderDate(new Date());
        orderRepository.save(order);


        return new CreateOrderResponse(null);
    }

}
