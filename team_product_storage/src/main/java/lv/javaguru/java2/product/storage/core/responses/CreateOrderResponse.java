package lv.javaguru.java2.product.storage.core.responses;

import java.util.List;

public class CreateOrderResponse extends CoreResponse {

    public CreateOrderResponse(List<CoreError> errors) {
        super(errors);
    }

}
