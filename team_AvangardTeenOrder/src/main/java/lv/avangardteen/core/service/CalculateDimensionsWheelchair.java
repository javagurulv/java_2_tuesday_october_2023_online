package lv.avangardteen.core.service;

import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import org.springframework.stereotype.Component;

@Component
public class CalculateDimensionsWheelchair {

    Wheelchair wheelchair = new Wheelchair();

    public Wheelchair setDimensions(Integer pelvisWidth, Integer thighLength,
                                    Integer shinLength, Integer backHeight) {
        wheelchair.setSeatWidth(findSeatWidth(pelvisWidth));
        wheelchair.setSeatDepth(findSeatDepth(thighLength));
        wheelchair.setFootrestLength(findFootrestLength(shinLength));
        wheelchair.setBachHeight(backHeight);
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
    private Integer findSeatDepth(Integer thighLength ) {
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
        if (footrestLength <= 40) {
            footrestLength = 40;
        }
        if (footrestLength > 40 && footrestLength <= 47) {
            footrestLength = 41;
        }
        if (footrestLength > 47) {
            footrestLength = 42;
        }
        return footrestLength;

    }
}
