package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderItemRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.AddProductToCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddProductToCartRequestValidator {

	@Autowired private JpaProductRepository productRepository;
	@Autowired private JpaOrderRepository orderRepository;
	@Autowired private JpaOrderItemRepository orderItemRepository;

	public List<CoreError> validate(AddProductToCartRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateOrderIdEmpty(request).ifPresent(errors::add);
		validateProductIdEmpty(request).ifPresent(errors::add);
		validateQuantityEmpty(request).ifPresent(errors::add);
		validateOrderIdExistInDb(request).ifPresent(errors::add);
		validateProductIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateOrderIdEmpty(AddProductToCartRequest request) {
		return (request.getOrderId() == null)
				? Optional.of(new CoreError("orderId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateProductIdEmpty(AddProductToCartRequest request) {
		return (request.getProductId() == null)
				? Optional.of(new CoreError("productId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateQuantityEmpty(AddProductToCartRequest request) {
		return (request.getQuantity() == null)
				? Optional.of(new CoreError("quantity", "Must be greater than 0!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateOrderIdExistInDb(AddProductToCartRequest request) {
		if (request.getOrderId() != null) {
			Optional<Order> orderOpt = orderRepository.findById(request.getOrderId());
			return (orderOpt.isEmpty())
					? Optional.of(new CoreError("orderId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	private Optional<CoreError> validateProductIdExistInDb(AddProductToCartRequest request) {
		if (request.getProductId() != null) {
			Optional<Product> productOpt = productRepository.findById(request.getProductId());
			return (productOpt.isEmpty())
					? Optional.of(new CoreError("productId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}


}







