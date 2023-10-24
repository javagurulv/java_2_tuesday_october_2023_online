package lv.avangardteen.core.responce;

import lv.avangardteen.WheelchairComponent;

import java.util.List;

public class ChooseWheelchairComponentResponse extends CoreResponse{

    WheelchairComponent wheelchairComponent;

    public ChooseWheelchairComponentResponse (List<CoreError> errors) {
        super(errors);
    }
    public ChooseWheelchairComponentResponse (WheelchairComponent wheelchairComponent) {
        this.wheelchairComponent = wheelchairComponent;
    }

    public WheelchairComponent getWheelchairComponent() {
        return wheelchairComponent;
    }
}
