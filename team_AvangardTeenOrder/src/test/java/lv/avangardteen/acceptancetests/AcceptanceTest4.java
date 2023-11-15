package lv.avangardteen.acceptancetests;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.core.service.ShowOrderService;
import lv.avangardteen.dependency_injection.ApplicationContext;
import lv.avangardteen.dependency_injection.DIApplicationContextBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest4 {
    private ApplicationContext appContext = new DIApplicationContextBuilder().build("lv.avangardteen");

    @Test
    public void checkPriceOfDifferentBrakes() {
        ClientRequest request1 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                 31, 41);
        getClientService().execute(request1);

        ClientRequest request2 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                32, 41);
        getClientService().execute(request2);

        ClientRequest request3 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                33, 41);
        getClientService().execute(request3);

        ShowOrderResponse response4 = getShowOrderService().execute(new ShowOrderRequest(1L));
        ShowOrderResponse response5 = getShowOrderService().execute(new ShowOrderRequest(2L));
        ShowOrderResponse response6 = getShowOrderService().execute(new ShowOrderRequest(3L));

        assertEquals(response4.getClient().getId(), 1);
        assertEquals(response4.getClient().getPriseOrder(), 199700);
        assertEquals(response5.getClient().getId(), 2);
        assertEquals(response5.getClient().getPriseOrder(), 201200);
        assertEquals(response6.getClient().getId(), 3);
        assertEquals(response6.getClient().getPriseOrder(), 205400);
    }

    private ClientService getClientService () {
        return appContext.getBean(ClientService.class);
    }
    private ShowOrderService getShowOrderService () {
        return appContext.getBean(ShowOrderService.class);
    }

}
