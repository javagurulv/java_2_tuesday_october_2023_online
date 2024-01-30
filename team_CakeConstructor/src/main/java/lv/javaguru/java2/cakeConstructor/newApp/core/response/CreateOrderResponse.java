package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import java.util.List;

public class CreateOrderResponse extends CoreResponse {

    public CreateOrderResponse(List<CoreError> errors) {
        super(errors);
    }

}
