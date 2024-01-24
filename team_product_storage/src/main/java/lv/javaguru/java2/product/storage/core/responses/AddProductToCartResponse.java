package lv.javaguru.java2.product.storage.core.responses;

import java.util.List;

public class AddProductToCartResponse extends CoreResponse {

    public AddProductToCartResponse(List<CoreError> errors) {
        super(errors);
    }

}
