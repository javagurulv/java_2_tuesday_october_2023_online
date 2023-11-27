package lv.avangardteen.acceptancetests;

import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.core.service.ShowOrderService;
import lv.avangardteen.dependency_injection.DIApplicationContextBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest1 {
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void shouldReturnOrderData() {
        ClientRequest request = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                 31, 41);
        getClientService().execute(request);

        ClientRequest request2 = new ClientRequest("Olga", 54321, "Tallin",
                11,21, 31, 41, 17,21,
                31, 41);
        getClientService().execute(request2);

        ShowOrderResponse response = getShowOrderService().execute(new ShowOrderRequest(1L));

        ShowOrderResponse response2 = getShowOrderService().execute(new ShowOrderRequest(2L));
        assertEquals(response.getClient().getId(), 1);
        assertEquals(response.getClient().getNameSurname(), "Alex");
        assertEquals(response.getClient().getPhoneNumber(), 123456);
        assertEquals(response.getClient().getUserAddress(), "Riga");
        assertEquals(response.getClient().getUserSizes().getShinLength(), 11);
        assertEquals(response.getClient().getUserSizes().getBackHeight(), 22);
        assertEquals(response.getClient().getUserSizes().getThighLength(), 33);
        assertEquals(response.getClient().getUserSizes().getPelvisWidth(), 44);

        // V ClientService "UserSize" popravils popravil konstruktor, o4erjednostj poda4i parametrov.
        // nado li proverjat Index komponentov, poka ne ponimaju kak.

        assertEquals(response2.getClient().getId(), 2);
        assertEquals(response2.getClient().getNameSurname(), "Olga");
        assertEquals(response2.getClient().getPhoneNumber(), 54321);
        assertEquals(response2.getClient().getUserAddress(), "Tallin");
        assertEquals(response2.getClient().getUserSizes().getShinLength(), 11);
        assertEquals(response2.getClient().getUserSizes().getBackHeight(), 21);
        assertEquals(response2.getClient().getUserSizes().getThighLength(), 31);
        assertEquals(response2.getClient().getUserSizes().getPelvisWidth(), 41);

    }

    private ClientService getClientService () {
        return appContext.getBean(ClientService.class);
    }

    private ShowOrderService getShowOrderService () {
        return appContext.getBean(ShowOrderService.class);
    }

}
