package lv.avangardteen.core.service;

import lv.avangardteen.UserSizes;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ChangePersonalSizeServiceMockitaTest {

    private ChangePersonalSizeService service;
    private Database database;
    private ChangePersonalSizeValidator validator;
    private UserSizes userSizes;
    @Test
    public void ChangePersonalSizeServiceWithError(){
        ChangePersonalSizeRequest notValideRequest = new ChangePersonalSizeRequest(1,22,33,44,45);
        validator = Mockito.mock(ChangePersonalSizeValidator.class);
        Mockito.when(validator.validate(notValideRequest)).thenReturn(
                List.of(new CoreError("Change Persona Size", "Incorrect personal sizes !")));
        service = new ChangePersonalSizeService(null,validator);
        ChangePersonalSizeResponse response = service.execute(notValideRequest);
        assertTrue(response.hasErrors());
    }
    /*

    @Test
    public void ChangePersonalDateWithoutError () {
        database = Mockito.mock(Database.class);
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(1,22,33,44,45);
        validator = Mockito.mock(ChangePersonalSizeValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        service = new ChangePersonalSizeService(database,validator);
        ChangePersonalSizeResponse response = service.execute(request);
        assertFalse(response.hasErrors());
    } */

}