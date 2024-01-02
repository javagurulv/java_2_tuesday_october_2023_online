package lv.avangardteen.core.responce;

import java.util.List;

public class ComponentRegistrationResponse extends CoreResponse{
    Integer wheelFrontChoose;
    Integer wheelBackChoose;
    Integer brakeChoose;
    Integer footrestChoose;


    public ComponentRegistrationResponse(List<CoreError> errors) {
        super(errors);
    }
    public ComponentRegistrationResponse() {}

    public Integer getWheelFrontChoose() {
        return wheelFrontChoose;
    }

    public void setWheelFrontChoose(Integer wheelFrontChoose) {
        this.wheelFrontChoose = wheelFrontChoose;
    }

    public Integer getWheelBackChoose() {
        return wheelBackChoose;
    }

    public void setWheelBackChoose(Integer wheelBackChoose) {
        this.wheelBackChoose = wheelBackChoose;
    }

    public Integer getBrakeChoose() {
        return brakeChoose;
    }

    public void setBrakeChoose(Integer brakeChoose) {
        this.brakeChoose = brakeChoose;
    }

    public Integer getFootrestChoose() {
        return footrestChoose;
    }

    public void setFootrestChoose(Integer footrestChoose) {
        this.footrestChoose = footrestChoose;
    }
}
