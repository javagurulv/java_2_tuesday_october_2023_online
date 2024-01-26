package lv.avangardteen.core.responce;

import java.util.List;

public class DeleteOrderResponse extends CoreResponse {

    private boolean removeOrder;

    public DeleteOrderResponse(List<CoreError> errors) {
       super(errors);
    }

    public DeleteOrderResponse(boolean removeOrder) {
        this.removeOrder = removeOrder;

    }
    public DeleteOrderResponse(){}
    public boolean isOrderRemoved() {
        return removeOrder;
    }

}
