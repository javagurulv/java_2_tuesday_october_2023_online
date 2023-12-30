package lv.avangardteen.core.request;

public class ChangeComponentRequest {
    Long id;
    Integer wheelFrontChoose;
    Integer wheelBackChoose;
    Integer brakeChoose;
    Integer footrestChoose;


    public ChangeComponentRequest(Long id, Integer wheelFrontChoose,
                                  Integer wheelBackChoose, Integer brakeChoose,
                                  Integer footrestChoose) {
        this.id = id;
        this.wheelFrontChoose = wheelFrontChoose;
        this.wheelBackChoose = wheelBackChoose;
        this.brakeChoose = brakeChoose;
        this.footrestChoose = footrestChoose;
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

    public Integer getFootrestChoose() {
        return footrestChoose;
    }
}
