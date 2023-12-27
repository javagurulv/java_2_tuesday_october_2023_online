package lv.avangardteen.core.dto;

import java.util.Objects;

public class UserSizes {
    private Long id;
    private Integer pelvisWidth; //ширина таза
    private Integer thighLength; //длина бедра
    private Integer backHeight; //высота спины
    private Integer shinLength; //длина голени


    public UserSizes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSizes userSizes = (UserSizes) o;
        return Objects.equals(id, userSizes.id) && Objects.equals(pelvisWidth, userSizes.pelvisWidth) && Objects.equals(thighLength, userSizes.thighLength) && Objects.equals(backHeight, userSizes.backHeight) && Objects.equals(shinLength, userSizes.shinLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pelvisWidth, thighLength, backHeight, shinLength);
    }

    @Override
    public String toString() {
        return  "ширина таза =" + pelvisWidth + '\n' +
                " длинна бедра =" + thighLength + '\n' +
                " высота спины =" + backHeight + '\n' +
                " длинна голени =" + shinLength + '\n';

    }
}
