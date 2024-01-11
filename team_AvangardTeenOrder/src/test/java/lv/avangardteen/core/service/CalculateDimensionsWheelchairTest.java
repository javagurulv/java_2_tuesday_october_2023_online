package lv.avangardteen.core.service;


import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CalculateDimensionsWheelchairTest {

    @Mock
    private Wheelchair wheelchair;
    @Mock
    CalculateDimensionsWheelchair calculate;

    @Test
    public void setWheelchair() {
        calculate = new CalculateDimensionsWheelchair();
        wheelchair = new Wheelchair();

        wheelchair = calculate.setDimensions(33,33, 33, 33);
        assertEquals(wheelchair.getBachHeight(), 33);
        assertEquals(wheelchair.getFootrestLength(), 40);
        assertEquals(wheelchair.getSeatDepth(), 32);
        assertEquals(wheelchair.getSeatWidth(), 36);
    }


}
