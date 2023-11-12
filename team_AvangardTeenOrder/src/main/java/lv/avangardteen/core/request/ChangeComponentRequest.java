package lv.avangardteen.core.request;

import lv.avangardteen.core.service.WheelchairComponent;

public class ChangeComponentRequest {
    Long id;
    Integer wheelFrontChoose;
    Integer wheelBackChoose;
    Integer brakeChoose;
    Integer armrestChoose;
    WheelchairComponent wheelchairComponent = new WheelchairComponent();

    public ChangeComponentRequest(Long id, Integer wheelFrontChoose,
                                  Integer wheelBackChoose, Integer brakeChoose,
                                  Integer armrestChoose) {
        this.id = id;
        this.wheelFrontChoose = wheelFrontChoose;
        this.wheelBackChoose = wheelBackChoose;
        this.brakeChoose = brakeChoose;
        this.armrestChoose = armrestChoose;
    }

    public Long getId() {
        return id;
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
