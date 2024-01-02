package lv.avangardteen.core.request;

public class ComponentRegistrationRequest {
    Integer wheelFrontChoose;
    Integer wheelBackChoose;
    Integer brakeChoose;
    Integer footrestChoose;


    public ComponentRegistrationRequest(Integer wheelFrontChoose,
                                  Integer wheelBackChoose, Integer brakeChoose,
                                  Integer footrestChoose) {
        this.wheelFrontChoose = wheelFrontChoose;
        this.wheelBackChoose = wheelBackChoose;
        this.brakeChoose = brakeChoose;
        this.footrestChoose = footrestChoose;
    }

    public Integer getWheelFrontChoose() {
        return wheelFrontChoose;
    }

    public Integer getWheelBackChoose() {
        return wheelBackChoose;
    }

    public Integer getBrakeChoose() {
        return brakeChoose;
    }

    public Integer getFootrestChoose() {
        return footrestChoose;
    }
}
