package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderItemRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.requests.GetTotalAmountRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetTotalAmountRequestValidator {

	@Autowired private JpaCustomerRepository customerRepository;
	@Autowired private JpaProductRepository productRepository;
	@Autowired private JpaOrderRepository orderRepository;
	@Autowired private JpaOrderItemRepository orderItemRepository;

	public List<CoreError> validate(GetTotalAmountRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateOrderIdEmpty(request).ifPresent(errors::add);
		validateOrderIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateOrderIdEmpty(GetTotalAmountRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("orderId", "Must not be empty!"))
				: Optional.empty();
	}


	private Optional<CoreError> validateOrderIdExistInDb(GetTotalAmountRequest request) {
		if (request.getId() != null) {
			Optional<Order> orderOpt = orderRepository.findById(request.getId());
			return (orderOpt.isEmpty())
					? Optional.of(new CoreError("orderId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}



}
