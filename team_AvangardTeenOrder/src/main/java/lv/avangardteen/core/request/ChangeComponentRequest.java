package lv.avangardteen.core.request;

public class ChangeComponentRequest {
    int id;
    String wheelFrontChoose;
    String wheelBackChoose;
    String brakeChoose;
    String armrestChoose;

    public ChangeComponentRequest(int id, String wheelFrontChoose,
                                  String wheelBackChoose, String brakeChoose, String armrestChoose) {
        this.id = id;
        this.wheelFrontChoose = wheelFrontChoose;
        this.wheelBackChoose = wheelBackChoose;
        this.brakeChoose = brakeChoose;
        this.armrestChoose = armrestChoose;
    }

    public int getId() {
        return id;
    }

    public String getWheelFrontChoose() {
        return wheelFrontChoose;
    }

    public String getWheelBackChoose() {
        return wheelBackChoose;
    }

    public String getBrakeChoose() {
        return brakeChoose;
    }

    public String getArmrestChoose() {
        return armrestChoose;
    }
}
