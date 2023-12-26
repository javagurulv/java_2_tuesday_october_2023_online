package lv.avangardteen.core.responce;

import lv.avangardteen.core.service.WheelchairComponent;

import java.util.List;

public class ComponentRegistrationResponse extends CoreResponse{

    WheelchairComponent wheelchairComponent;


    public ComponentRegistrationResponse(List<CoreError> errors) {
        super(errors);
    }
    public ComponentRegistrationResponse() {}


    public WheelchairComponent getWheelchairComponent() {
        return wheelchairComponent;
    }

    public void setWheelchairComponent(WheelchairComponent wheelchairComponent) {
        this.wheelchairComponent = wheelchairComponent;
    }
}
