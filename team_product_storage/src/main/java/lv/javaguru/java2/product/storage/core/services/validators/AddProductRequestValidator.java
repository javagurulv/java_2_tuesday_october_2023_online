package lv.javaguru.java2.product.storage.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class AddProductRequestValidator {

    @Autowired private JpaProductRepository productRepository;

    public List<CoreError> validate(AddProductRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateProductName(request).ifPresent(errors::add);
        validateProductBrand(request).ifPresent(errors::add);
        validateProductModel(request).ifPresent(errors::add);
        validateProductQuantity(request).ifPresent(errors::add);
        validatePrice(request).ifPresent(errors::add);
        validateDuplicate(request).ifPresent(errors::add);
        return errors;
    }


    private Optional<CoreError> validateProductName(AddProductRequest request) {
        return (request.getProductName() == null || request.getProductName().isEmpty())
                ? Optional.of(new CoreError("productName", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProductBrand(AddProductRequest request) {
        return (request.getProductBrand() == null || request.getProductBrand().isEmpty())
                ? Optional.of(new CoreError("productBrand", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProductModel(AddProductRequest request) {
        return (request.getProductModel() == null || request.getProductModel().isEmpty())
                ? Optional.of(new CoreError("productModel", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProductQuantity(AddProductRequest request) {
        return (request.getProductQuantity() == null)
                ? Optional.of(new CoreError("productQuantity", "Must be greater than 0!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePrice(AddProductRequest request) {
        BigDecimal minPrice = new BigDecimal("0.01");
        return (request.getPrice() == null)
                ? Optional.of(new CoreError("price", "Must be greater than 0.00!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateDuplicate(AddProductRequest request) {
        List<Product> products = productRepository.findByProductBrandAndProductModel(request.getProductBrand(), request.getProductModel());
        return (!products.isEmpty())
                ? Optional.of(new CoreError("duplicate", "Duplicate product not accepted!"))
                : Optional.empty();
    }
}
