package lv.avangardteen.core.responce;

import lv.avangardteen.Client;

import java.util.List;

public class DeleteOrderResponse extends CoreResponse {

    private boolean removeOrder;

    public DeleteOrderResponse(List<CoreError> errors) {
       super(errors);
    }

    public DeleteOrderResponse(boolean removeOrder) {
        this.removeOrder = removeOrder;

    }

    public boolean isOrderRemoved() {
        return removeOrder;
    }

}
