package lv.avangardteen.core.service;

import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalDateValidator;
import lv.avangardteen.core.data.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChangePersonalDateServiceMockitaTest {
    @Mock
    private Database database;
    @Mock
    private ChangePersonalDateValidator validator;
    @InjectMocks
    private ChangePersonalDateService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void ChangePersonalDateWithError() {
        ChangePersonalDateRequest notValidationRequest = new ChangePersonalDateRequest(1L, "Name", 123245, "Riga");
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(
                List.of(new CoreError("Change Persona Date", "Incorrect personal date!")));
        ChangePersonalDateResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ChangePersonalDateWithoutError() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1L, "Name", 123245, "Riga");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        ChangePersonalDateResponse response = service.execute(request);
        assertFalse(response.hasErrors());

    }

}