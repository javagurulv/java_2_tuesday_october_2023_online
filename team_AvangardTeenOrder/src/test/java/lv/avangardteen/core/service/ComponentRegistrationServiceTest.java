package lv.avangardteen.core.service;


import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.database.WComponentsDB;
import lv.avangardteen.core.database.WheelchairDB;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ComponentValidator;
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

class ComponentRegistrationServiceTest {

    @Mock
    private Database database;
    @Mock
    private DataComponents dataComponents;
    @Mock
    private WheelchairDB wheelchairDB;
    @Mock
    private WComponentsDB wComponentsDB;

    @Mock
    private ComponentValidator validator;
 @InjectMocks
 private  ComponentRegistrationService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ChangeComponentExecuteWithError() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1l, 11,12,13,14);
        when(validator.validate(request)).thenReturn(
                List.of(new CoreError("indexFrontWheel", "This index is absent!")));
        ComponentRegistrationResponse response = service.execute(request);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ChangeComponentWithoutError() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1l, 11,12,13,14);

        when(validator.validate(request)).thenReturn(List.of());
        ComponentRegistrationResponse response = service.execute(request);
        assertFalse(response.hasErrors());


        verify(wComponentsDB, times(4)).addWheelchairComponents(any());


    }

}
