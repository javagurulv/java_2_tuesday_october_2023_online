package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.domain.OrderItem;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.services.validators.AddProductToCartRequestValidator;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderItemRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.requests.AddProductToCartRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductToCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddProductToCartService {

    @Autowired private AddProductToCartRequestValidator validator;
    @Autowired private JpaProductRepository productRepository;
    @Autowired private JpaOrderRepository orderRepository;
    @Autowired private JpaOrderItemRepository orderItemRepository;


    public AddProductToCartResponse execute(AddProductToCartRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddProductToCartResponse(errors);
        }

        Order order = orderRepository.getReferenceById(request.getOrderId());
        Product product = productRepository.getReferenceById(request.getProductId());


        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(request.getQuantity());

        orderItemRepository.save(orderItem);

        return new AddProductToCartResponse(null);
    }

}
