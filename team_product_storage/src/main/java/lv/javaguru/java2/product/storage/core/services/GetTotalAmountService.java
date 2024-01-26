package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderItemRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.requests.GetTotalAmountRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.GetTotalAmountResponse;
import lv.javaguru.java2.product.storage.core.services.validators.GetTotalAmountRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetTotalAmountService {

    @Autowired private GetTotalAmountRequestValidator validator;
    @Autowired private JpaProductRepository productRepository;
    @Autowired private JpaOrderRepository orderRepository;
    @Autowired private JpaCustomerRepository customerRepository;
    @Autowired private JpaOrderItemRepository orderItemRepository;


    public GetTotalAmountResponse execute(GetTotalAmountRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetTotalAmountResponse(errors);
        }

        return orderRepository.findById(request.getId())
                .map(order -> {
                    order.setTotalAmount(orderRepository.sumTotalAmount(request.getId()));
                    return new GetTotalAmountResponse(List.of());
                })
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetTotalAmountResponse(errors);
                });
    }


}
