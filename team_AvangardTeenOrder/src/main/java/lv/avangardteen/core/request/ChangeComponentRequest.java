package lv.avangardteen.core.request;

public class ChangeComponentRequest {
    Long id;
    Integer wheelFrontChoose;
    Integer wheelBackChoose;
    Integer brakeChoose;
    Integer armrestChoose;

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

    public Integer getWheelFrontChoose() {
        return wheelFrontChoose;
    }

    public Integer getWheelBackChoose() {
        return wheelBackChoose;
    }

    public Integer getBrakeChoose() {
        return brakeChoose;
    }

    public Integer getArmrestChoose() {
        return armrestChoose;
    }
}
