package lv.avangardteen.core.service;
/*


import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
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
import static org.mockito.Mockito.when;

class ChangeComponentServiceMockTest {

    @Mock private Database database;
    @Mock private ChooseComponentValidator validator;
    @InjectMocks private ChangeComponentService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ChangeComponentExecuteWithError() {
        ChangeComponentRequest request = new ChangeComponentRequest(
                0L, 11,12,13,14);
       Mockito.when(validator.validate(request)).thenReturn(
                List.of(new CoreError("Change Component", "Incorrect component choose!")));
        ChangeComponentResponse response = service.execute(request);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ChangeComponentWithoutError() {
        ChangeComponentRequest request = new ChangeComponentRequest(
                1L, 11, 12, 13, 14);
        when(database.getWheelchairComponents(request.getId())).thenReturn(new WheelchairComponent());
        when(validator.validate(request)).thenReturn(List.of());
        ChangeComponentResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(database).updateWheelchairComponents(request.getId(), request.getWheelchairComponent());


    }
}
*/
