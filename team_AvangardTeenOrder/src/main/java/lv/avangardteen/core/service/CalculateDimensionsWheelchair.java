package lv.avangardteen.core.service;

import lv.avangardteen.dto.UserSizes;
import lv.avangardteen.dto.Wheelchair;

public class CalculateDimensionsWheelchair {


    private UserSizes userSizes;

    private Wheelchair wheelchair;

    public CalculateDimensionsWheelchair(UserSizes userSizes, Wheelchair wheelchair) {
        this.userSizes = userSizes;
        this.wheelchair = wheelchair;
    }

    public Wheelchair setDimensions(UserSizes userSizes) {
        wheelchair.setSeatWidth(findSeatWidth(userSizes.getPelvisWidth()));
        wheelchair.setSeatDepth(findSeatDepth(userSizes.getThighLength()));
        wheelchair.setFootrestLength(findFootrestLength(userSizes.getShinLength()));
        wheelchair.setBachHeight(userSizes.getBackHeight());
        return wheelchair;
    }

    private Integer findSeatWidth(Integer pelvisWidth) {
        int seatWidth = pelvisWidth + 4;
        if (seatWidth <= 22) {
            seatWidth = 22;
        }
        if (seatWidth > 22 && seatWidth <= 24) {
            seatWidth = 24;
        }
        if (seatWidth > 24 && seatWidth <= 26) {
            seatWidth = 26;
        }
        if (seatWidth > 26 && seatWidth <= 28) {
            seatWidth = 28;
        }
        if (seatWidth > 28 && seatWidth <= 30) {
            seatWidth = 30;
        }
        if (seatWidth > 30 && seatWidth <= 32) {
            seatWidth = 32;
        }
        if (seatWidth > 32 && seatWidth <= 34) {
            seatWidth = 34;
        }
        if (seatWidth > 34) {
            seatWidth = 36;
        }
        return seatWidth;
    }

    //глубина сиденья
    private Integer findSeatDepth(Integer thighLength) {
        int seatDepth = thighLength - 2;
        if (seatDepth <= 24) {
            seatDepth = 24;
        }
        if (seatDepth > 24 && seatDepth <= 26) {
            seatDepth = 26;
        }
        if (seatDepth > 26 && seatDepth <= 28) {
            seatDepth = 28;
        }
        if (seatDepth > 28 && seatDepth <= 30) {
            seatDepth = 30;
        }
        if (seatDepth > 30 && seatDepth <= 32) {
            seatDepth = 32;
        }
        if (seatDepth > 32 && seatDepth <= 34) {
            seatDepth = 34;
        }
        if (seatDepth > 34 && seatDepth <= 36) {
            seatDepth = 36;
        }
        if (seatDepth > 36 && seatDepth <= 38) {
            seatDepth = 38;
        }
        if (seatDepth > 38) {
            seatDepth = 40;
        }
        return seatDepth;
    }

    //длинна подножки
    private Integer findFootrestLength(Integer shinLength) {
        int footrestLength = shinLength;
        if (shinLength <= 40) {
            footrestLength = 40;
        }
        if (shinLength > 40 && shinLength <= 47) {
            footrestLength = 41;
        }
        if (shinLength > 47) {
            footrestLength = 42;
        }
        return footrestLength;

    }
}
