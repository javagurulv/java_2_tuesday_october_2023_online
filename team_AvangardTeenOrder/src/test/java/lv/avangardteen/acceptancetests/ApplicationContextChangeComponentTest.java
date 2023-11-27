package lv.avangardteen.acceptancetests;

import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.ChangeComponentService;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.core.dto.Category;
import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.dto.Components;
import lv.avangardteen.core.service.WheelchairComponent;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationContextChangeComponentTest {

    @Mock
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void changeComponentTest() {

        ClientRequest request1 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                31, 41);
        getClientService().execute(request1);

        ChangeComponentRequest request = new ChangeComponentRequest(1l, 12, 22, 32, 42);

        ChangeComponentResponse response = getChangeComponentService().execute(request);
        Client client = response.getClient();
        WheelchairComponent componentMap = client.getWheelchairComponents();
        Map<Category, Components> getMap = componentMap.getComponents();
        assertEquals(getMap.get(Category.FRONT_WHEEL).getIndex(), 12);
        assertEquals(getMap.get(Category.BACK_WHEEL).getIndex(), 22);
        assertEquals(getMap.get(Category.BRAKE).getIndex(), 32);
        assertEquals(getMap.get(Category.ARMREST).getIndex(), 42);

    }

    @Test
    public void threwAnError() {
        ClientRequest request1 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                31, 41);
        getClientService().execute(request1);

        ChangeComponentRequest request = new ChangeComponentRequest(null, 12, 22, 32, 42);

        ChangeComponentResponse response = getChangeComponentService().execute(request);
        List<CoreError> errors = response.getErrors();
        assertEquals(errors.size(), 1);
    }

    private ClientService getClientService() {
        return appContext.getBean(ClientService.class);
    }

    private ChangeComponentService getChangeComponentService() {
        return appContext.getBean(ChangeComponentService.class);
    }

}