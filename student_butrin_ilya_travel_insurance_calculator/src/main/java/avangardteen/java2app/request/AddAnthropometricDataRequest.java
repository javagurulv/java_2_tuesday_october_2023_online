package avangardteen.java2app.request;

public class AddAnthropometricDataRequest {
    int pelwicWidth;
    int thighLength;
    int backLength;
    int shinLength;

    public AddAnthropometricDataRequest(int pelwicWidth, int thighLength, int backLength, int shinLength) {
        this.pelwicWidth = pelwicWidth;
        this.thighLength = thighLength;
        this.backLength = backLength;
        this.shinLength = shinLength;
    }

    public int getPelwicWidth() {
        return pelwicWidth;
    }

    public int getThighLength() {
        return thighLength;
    }

    public int getBackLength() {
        return backLength;
    }

    public int getShinLength() {
        return shinLength;
    }
}
