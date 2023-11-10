package lv.avangardteen.core.request;

public class ChangePersonalSizeRequest {
    public Long id;
    public Integer pelvisWidth; //ширина таза
    public Integer thighLength; //длинна бедра
    public Integer backHeight; //высота спины
    public Integer shinLength; //длинна голени

    public ChangePersonalSizeRequest(Long id, Integer pelvisWidth, Integer thighLength, Integer backHeight, Integer shinLength) {
        this.id = id;
        this.pelvisWidth = pelvisWidth;
        this.thighLength = thighLength;
        this.backHeight = backHeight;
        this.shinLength = shinLength;
    }


    public Long getId() {
        return id;
    }

    public Integer getPelvisWidth() {
        return pelvisWidth;
    }

    public Integer getThighLength() {
        return thighLength;
    }

    public Integer getBackHeight() {
        return backHeight;
    }

    public Integer getShinLength() {
        return shinLength;
    }
}
