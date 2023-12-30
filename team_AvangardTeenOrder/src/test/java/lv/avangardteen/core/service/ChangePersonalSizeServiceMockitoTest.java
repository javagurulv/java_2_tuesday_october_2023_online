package lv.avangardteen.core.service;
/*


import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import lv.avangardteen.core.database.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ChangePersonalSizeServiceMockitoTest {

    @Mock
    private Database database;
    @Mock
    private CalculateDimensionsWheelchair calculateDimensionsWheelchair;
    @Mock
    private ChangePersonalSizeValidator validator;
    @InjectMocks
    private ChangePersonalSizeService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ChangePersonalSizeServiceWithError() {
        ChangePersonalSizeRequest notErrorsRequest = new ChangePersonalSizeRequest(1L, 22, 33, 44, 45);
        Mockito.when(validator.validate(notErrorsRequest)).thenReturn(
                List.of(new CoreError("Change Persona Size", "Incorrect personal sizes !")));
        ChangePersonalSizeResponse response = service.execute(notErrorsRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ChangePersonalSizeWithoutError() {
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(1L, 22, 33, 44, 45);
        Mockito.when(database.getUserSize(request.getId())).thenReturn(new UserSizes());
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        ChangePersonalSizeResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(database).updateUserSize(request.getId(), request.getUserSizes());
        verify(database).updateWheelchair(request.getId(), calculateDimensionsWheelchair.setDimensions(request.getUserSizes()));

    }

}
*/
