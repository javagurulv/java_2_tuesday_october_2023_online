package lv.avangardteen.core.service;

import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.dto.Wheelchair;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CalculateDimensionsWheelchairTest {
    @Mock
    private UserSizes userSizes;
    @Mock
    private Wheelchair wheelchair;
    @Mock
    CalculateDimensionsWheelchair calculate;

    @Test
    public void setWheelchair() {
        userSizes = Mockito.mock(UserSizes.class);
        wheelchair = new Wheelchair();
        Mockito.when(userSizes.getBackHeight()).thenReturn(33);
        Mockito.when(userSizes.getPelvisWidth()).thenReturn(33);
        Mockito.when(userSizes.getThighLength()).thenReturn(33);
        Mockito.when(userSizes.getShinLength()).thenReturn(33);
        calculate = new CalculateDimensionsWheelchair();
        wheelchair = calculate.setDimensions(userSizes);
        assertEquals(wheelchair.getBachHeight(), 33);
        assertEquals(wheelchair.getFootrestLength(), 40);
        assertEquals(wheelchair.getSeatDepth(), 32);
        assertEquals(wheelchair.getSeatWidth(), 36);
    }


}