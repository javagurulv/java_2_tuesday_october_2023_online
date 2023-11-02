package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChangeComponentServiceMockTest {

    private Database database;
    private ChooseComponentValidator validator;
    private ChangeComponentService service;

    @Test
    public void ChangeComponentExecuteWithError() {
        ChangeComponentRequest notValideRequest = new ChangeComponentRequest(
                0L, 11,12,13,14);
        validator = Mockito.mock(ChooseComponentValidator.class);
        Mockito.when(validator.validate(notValideRequest)).thenReturn(
                List.of(new CoreError("Change Component", "Incorrect component chose!")));
        service = new ChangeComponentService(null,validator);
        ChangeComponentResponse response = service.execute(notValideRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ChangeComponentWithoutError() {
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(ChooseComponentValidator.class);
        ChangeComponentRequest request = new ChangeComponentRequest(
                1L, 11, 12, 13, 14);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        service = new ChangeComponentService(database, validator);
        ChangeComponentResponse response = service.execute(request);
        assertFalse(response.hasErrors());

        // nado li proverjatj logiku dobavlenija componentov i obrazovanija ceni?
    }
}