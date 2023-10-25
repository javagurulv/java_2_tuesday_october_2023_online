package lv.avangardteen.core.request;

public class ChangePersonalSizeRequest {
    public int id;
    public int pelvisWidth; //ширина таза
    public int thighLength; //длинна бедра
    public int backHeight; //высота спины
    public int shinLength;

    public ChangePersonalSizeRequest(int id, int pelvisWidth, int thighLength, int backHeight, int shinLength) {
        this.id = id;
        this.pelvisWidth = pelvisWidth;
        this.thighLength = thighLength;
        this.backHeight = backHeight;
        this.shinLength = shinLength;
    }


    public int getId() {
        return id;
    }

    public int getPelvisWidth() {
        return pelvisWidth;
    }

    public int getThighLength() {
        return thighLength;
    }

    public int getBackHeight() {
        return backHeight;
    }

    public int getShinLength() {
        return shinLength;
    }
}
