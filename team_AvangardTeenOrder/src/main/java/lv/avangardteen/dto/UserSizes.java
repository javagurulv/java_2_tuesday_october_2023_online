package lv.avangardteen.dto;

public class UserSizes {
    public Integer pelvisWidth; //ширина таза
    public Integer thighLength; //длина бедра
    public Integer backHeight; //высота спины
    public Integer shinLength; //длина голени


    //ширина сиденья

    public Integer getPelvisWidth() {
        return pelvisWidth;
    }

    public void setPelvisWidth(Integer pelvisWidth) {
        this.pelvisWidth = pelvisWidth;
    }

    public Integer getThighLength() {
        return thighLength;
    }

    public void setThighLength(Integer thighLength) {
        this.thighLength = thighLength;
    }

    public Integer getBackHeight() {
        return backHeight;
    }

    public void setBackHeight(Integer backHeight) {
        this.backHeight = backHeight;
    }

    public Integer getShinLength() {
        return shinLength;
    }

    public void setShinLength(Integer shinLength) {
        this.shinLength = shinLength;
    }

    @Override
    public String toString() {
        return  "ширина таза =" + pelvisWidth + '\n' +
                " длинна бедра =" + thighLength + '\n' +
                " высота спины =" + backHeight +'\n'+
                " длинна голени =" + shinLength + '\n';

    }
}
