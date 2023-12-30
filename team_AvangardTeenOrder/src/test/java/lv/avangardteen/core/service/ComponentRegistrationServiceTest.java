package lv.avangardteen.core.service;
/*

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ComponentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ComponentRegistrationServiceTest {

    @Mock
    private Database database;
    @Mock private ComponentValidator validator;
    @InjectMocks
    private ComponentRegistrationService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ChangeComponentExecuteWithError() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                11,12,13,14);
        when(validator.validate(request.getWheelchairComponent())).thenReturn(
                List.of(new CoreError("Change Component", "Incorrect component chose!")));
        ComponentRegistrationResponse response = service.execute(request);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ChangeComponentWithoutError() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                11,12,13,14);

        when(validator.validate(request.getWheelchairComponent())).thenReturn(List.of());
        ComponentRegistrationResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(database).addWheelchairComponents(any());


    }

}*/
