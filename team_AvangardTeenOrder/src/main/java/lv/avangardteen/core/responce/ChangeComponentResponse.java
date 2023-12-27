package lv.avangardteen.core.responce;


import lv.avangardteen.core.dto.Order;
import lv.avangardteen.core.service.WheelchairComponent;

import java.util.List;

public class ChangeComponentResponse extends CoreResponse {
    WheelchairComponent wheelchairComponent;

    public ChangeComponentResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangeComponentResponse(WheelchairComponent wheelchairComponent) {

        this.wheelchairComponent = wheelchairComponent;
    }


    public void setWheelchairComponent(WheelchairComponent wheelchairComponent) {
        this.wheelchairComponent = wheelchairComponent;
    }
}
