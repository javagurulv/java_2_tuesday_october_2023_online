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

public class AcceptanceTest5 {
    private ApplicationContext appContext = new DIApplicationContextBuilder().build("lv.avangardteen");

    @Test
    public void checkPriceOfDifferentFrontWheel() {
        ClientRequest request1 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                 31, 41);
        getClientService().execute(request1);

        ClientRequest request2 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 12, 21,
                31, 41);
        getClientService().execute(request2);

        ClientRequest request3 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 13, 21,
                31, 41);
        getClientService().execute(request3);

        ClientRequest request4 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 14, 21,
                31, 41);
        getClientService().execute(request4);

        ClientRequest request5 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 15, 21,
                31, 41);
        getClientService().execute(request5);

        ClientRequest request6 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 16, 21,
                31, 41);
        getClientService().execute(request6);

        ClientRequest request7 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 17, 21,
                31, 41);
        getClientService().execute(request7);

        ShowOrderResponse response8 = getShowOrderService().execute(new ShowOrderRequest(1L));
        ShowOrderResponse response9 = getShowOrderService().execute(new ShowOrderRequest(2L));
        ShowOrderResponse response10 = getShowOrderService().execute(new ShowOrderRequest(3L));
        ShowOrderResponse response11 = getShowOrderService().execute(new ShowOrderRequest(4L));
        ShowOrderResponse response12 = getShowOrderService().execute(new ShowOrderRequest(5L));
        ShowOrderResponse response13 = getShowOrderService().execute(new ShowOrderRequest(6L));
        ShowOrderResponse response14 = getShowOrderService().execute(new ShowOrderRequest(7L));

        assertEquals(response8.getClient().getId(), 1);
        assertEquals(response8.getClient().getPriseOrder(), 199700);
        assertEquals(response9.getClient().getId(), 2);
        assertEquals(response9.getClient().getPriseOrder(), 199700);
        assertEquals(response10.getClient().getId(), 3);
        assertEquals(response10.getClient().getPriseOrder(), 199700);
        assertEquals(response11.getClient().getId(), 4);
        assertEquals(response11.getClient().getPriseOrder(), 199700);
        assertEquals(response12.getClient().getId(), 5);
        assertEquals(response12.getClient().getPriseOrder(), 210200);
        assertEquals(response13.getClient().getId(), 6);
        assertEquals(response13.getClient().getPriseOrder(), 210200);
        assertEquals(response14.getClient().getId(), 7);
        assertEquals(response14.getClient().getPriseOrder(), 210200);
    }

    private ClientService getClientService () {
        return appContext.getBean(ClientService.class);
    }
    private ShowOrderService getShowOrderService () {
        return appContext.getBean(ShowOrderService.class);
    }

}
