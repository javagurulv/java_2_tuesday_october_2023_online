package lv.avangardteen.core.service;


import lv.avangardteen.core.data.Database;
import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.dto.Wheelchair;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowOrderValidatorTest {
    @Mock
    private Database database;
    @Mock
    private ClientIdValidator idValidator;
    @InjectMocks
    private ShowOrderValidator validator;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void notErrors() {
        Mockito.when(database.getUserSize(1L)).thenReturn(new UserSizes());
        Mockito.when(database.getWheelchair(1L)).thenReturn(new Wheelchair());
        Mockito.when(database.getWheelchairComponents(1L)).thenReturn(new WheelchairComponent());
        ShowOrderRequest request = new ShowOrderRequest(1L);
        Mockito.when(idValidator.validate(request.getId())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void isErrors() {
        Mockito.when(database.getUserSize(1L)).thenReturn(new UserSizes());
        Mockito.when(database.getWheelchair(1L)).thenReturn(new Wheelchair());
        Mockito.when(database.getWheelchairComponents(1L)).thenReturn(new WheelchairComponent());
        ShowOrderRequest request = new ShowOrderRequest(1L);
        Mockito.when(idValidator.validate(request.getId())).thenReturn(List.of(
                new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

}