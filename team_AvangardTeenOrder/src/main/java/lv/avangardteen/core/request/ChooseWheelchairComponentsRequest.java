package lv.avangardteen.core.request;


public class ChooseWheelchairComponentsRequest {

    String markingWheel;
    String markingBrake;
    String markingArmrest;

    public ChooseWheelchairComponentsRequest(String markingWheel, String markingBrake, String markingArmrest) {
        this.markingWheel = markingWheel;
        this.markingBrake = markingBrake;
        this.markingArmrest = markingArmrest;
    }

    public String getMarkingWheel() {
        return markingWheel;
    }

    public String getMarkingBrake() {
        return markingBrake;
    }

    public String getMarkingArmrest() {
        return markingArmrest;
    }
}
