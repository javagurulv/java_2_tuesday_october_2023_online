package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;

@DIComponent
public class SearchProductsRequestFieldValidator {

    public List<CoreError> validate(SearchProductsRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getProductBrand()) && isEmpty(request.getProductModel())) {
            errors.add(new CoreError("productBrand", "Must not be empty!"));
            errors.add(new CoreError("productModel", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
