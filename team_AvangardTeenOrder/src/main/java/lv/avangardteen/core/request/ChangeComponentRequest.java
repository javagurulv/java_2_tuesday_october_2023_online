package lv.avangardteen.core.request;

public class ChangeComponentRequest {
    int id;
    int wheelFrontChoose;
    int wheelBackChoose;
    int brakeChoose;
    int armrestChoose;

    public ChangeComponentRequest(int id, int wheelFrontChoose,
                                  int wheelBackChoose, int brakeChoose,
                                  int armrestChoose) {
        this.id = id;
        this.wheelFrontChoose = wheelFrontChoose;
        this.wheelBackChoose = wheelBackChoose;
        this.brakeChoose = brakeChoose;
        this.armrestChoose = armrestChoose;
    }

    public int getId() {
        return id;
    }

    public int getWheelFrontChoose() {
        return wheelFrontChoose;
    }

    public int getWheelBackChoose() {
        return wheelBackChoose;
    }

    public int getBrakeChoose() {
        return brakeChoose;
    }

    public int getArmrestChoose() {
        return armrestChoose;
    }
}
