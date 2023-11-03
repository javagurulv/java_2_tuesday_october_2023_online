package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalDateValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChangePersonalDateServiceMockitaTest {
    private Database database;

    private ChangePersonalDateValidator validator;
    private ChangePersonalDateService service;

    @Test
    public void ChangePersonalDateWithError () {
        ChangePersonalDateRequest notValidationRequest = new ChangePersonalDateRequest(1L,"Name",123245,"Riga");
        validator = Mockito.mock(ChangePersonalDateValidator.class);
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(
                List.of(new CoreError("Change Persona Date", "Incorrect personal date!")));
        service = new ChangePersonalDateService(null,validator);
        ChangePersonalDateResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ChangePersonalDateWithoutError () {
        database = Mockito.mock(Database.class);
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1L,"Name",123245,"Riga");
        validator = Mockito.mock(ChangePersonalDateValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        service = new ChangePersonalDateService(database,validator);
        ChangePersonalDateResponse response = service.execute(request);
        assertFalse(response.hasErrors());


    }

}