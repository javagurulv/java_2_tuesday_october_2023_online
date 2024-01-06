package lv.avangardteen.core.request;

import lv.avangardteen.core.domain.UserSizes;

public class OrderRequest {
    public String userName;
    public long userPersonalCode;
    public Integer pelvisWidth; //ширина таза
    public Integer thighLength; //длинна бедра
    public Integer backHeight; //высота спины
    public Integer shinLength; //длинна голени


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
