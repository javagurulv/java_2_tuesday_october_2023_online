package lv.avangardteen.core.request;

import lv.avangardteen.core.domain.UserSizes;

public class OrderRequest {
    public String userName;
    public long userPersonalCode;
    public Integer pelvisWidth; //ширина таза
    public Integer thighLength; //длина бедра
    public Integer backHeight; //высота спины
    public Integer shinLength; //длина голени

    public OrderRequest() {
    }

    public OrderRequest(String userName, Long userPersonalCode,
                        Integer pelvisWidth, Integer thighLength,
                        Integer backHeight, Integer shinLength) {
        this.userName = userName;
        this.userPersonalCode = userPersonalCode;
        this.pelvisWidth = pelvisWidth;
        this.thighLength = thighLength;
        this.backHeight = backHeight;
        this.shinLength = shinLength;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPersonalCode(long userPersonalCode) {
        this.userPersonalCode = userPersonalCode;
    }

    public void setPelvisWidth(Integer pelvisWidth) {
        this.pelvisWidth = pelvisWidth;
    }

    public void setThighLength(Integer thighLength) {
        this.thighLength = thighLength;
    }

    public void setBackHeight(Integer backHeight) {
        this.backHeight = backHeight;
    }

    public void setShinLength(Integer shinLength) {
        this.shinLength = shinLength;
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

    public String getUserName() {
        return userName;
    }

    public Long getUserPersonalCode() {
        return userPersonalCode;
    }
}
