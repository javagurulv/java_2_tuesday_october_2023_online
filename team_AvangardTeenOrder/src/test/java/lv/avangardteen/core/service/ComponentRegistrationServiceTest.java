package lv.avangardteen.core.service;


import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.database.WComponentsDB;
import lv.avangardteen.core.database.WheelchairDB;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ComponentValidator;
import lv.avangardteen.core.service.validate.OrderIdValidator;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@Ignore
class ComponentRegistrationServiceTest {
    @Mock
    private WComponentsDB wComponentsDB;
    @Mock
    private OrderIdValidator idValidator;
    @Mock
    private ComponentValidator validator;
    @InjectMocks
    private ComponentRegistrationService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ChangeComponentExecuteWithError() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1l, 11, 12, 13, 14);
        when(idValidator.validate(request.getId())).thenReturn(List.of(new CoreError("id", "Is absent!")));
        when(validator.validate(request)).thenReturn(
                List.of(new CoreError("indexFrontWheel", "This index is absent!")));
        ComponentRegistrationResponse response = service.execute(request);
        List<CoreError> errors = response.getErrors();
        assertTrue(response.hasErrors());
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "id");
    }

    @Test
    public void ChangeComponentWithoutError() {

        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1l, 11, 12, 13, 14);
        //  when(dataComponents.allFrontWheels()).thenReturn(List.of(new Components()));
        when(idValidator.validate(1l)).thenReturn(List.of());
        when(validator.validate(request)).thenReturn(List.of());
        ComponentRegistrationResponse response = service.execute(request);
        assertFalse(response.hasErrors());


        verify(wComponentsDB, times(4)).addWheelchairComponents(any());


    }

}
