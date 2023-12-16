package lv.avangardteen.core.request;

import lv.avangardteen.core.service.WheelchairComponent;

public class ComponentRegistrationRequest {
    Integer wheelFrontChoose;
    Integer wheelBackChoose;
    Integer brakeChoose;
    Integer armrestChoose;
    WheelchairComponent wheelchairComponent = new WheelchairComponent();

    public ComponentRegistrationRequest(Integer wheelFrontChoose,
                                  Integer wheelBackChoose, Integer brakeChoose,
                                  Integer armrestChoose) {
        this.wheelFrontChoose = wheelFrontChoose;
        this.wheelBackChoose = wheelBackChoose;
        this.brakeChoose = brakeChoose;
        this.armrestChoose = armrestChoose;
    }

    public WheelchairComponent getWheelchairComponent() {
        return setWheelchairComponent();
    }

    public WheelchairComponent setWheelchairComponent() {
        wheelchairComponent.addComponents(wheelFrontChoose);
        wheelchairComponent.addComponents(wheelBackChoose);
        wheelchairComponent.addComponents(brakeChoose);
        wheelchairComponent.addComponents(armrestChoose);
        return wheelchairComponent;
    }

}
