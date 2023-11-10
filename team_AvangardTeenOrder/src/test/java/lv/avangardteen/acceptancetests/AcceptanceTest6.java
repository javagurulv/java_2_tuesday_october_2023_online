package lv.avangardteen.acceptancetests;

import lv.avangardteen.ApplicationContext;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.core.service.ShowOrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest6 {
    private ApplicationContext appContext = new ApplicationContext();

    @Test
    public void checkPriceOfDifferentArmrest() {
        ClientRequest request1 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                 31, 41);
        getClientService().execute(request1);

        ClientRequest request2 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                31, 42);
        getClientService().execute(request2);

        ClientRequest request3 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                31, 43);
        getClientService().execute(request3);

        ClientRequest request4 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                31, 44);
        getClientService().execute(request4);



        ShowOrderResponse response5 = getShowOrderService().execute(new ShowOrderRequest(1L));
        ShowOrderResponse response6 = getShowOrderService().execute(new ShowOrderRequest(2L));
        ShowOrderResponse response7 = getShowOrderService().execute(new ShowOrderRequest(3L));
        ShowOrderResponse response8 = getShowOrderService().execute(new ShowOrderRequest(4L));


        assertEquals(response5.getClient().getId(), 1);
        assertEquals(response5.getClient().getPriseOrder(), 199700);
        assertEquals(response6.getClient().getId(), 2);
        assertEquals(response6.getClient().getPriseOrder(), 203500);
        assertEquals(response7.getClient().getId(), 3);
        assertEquals(response7.getClient().getPriseOrder(), 211500);
        assertEquals(response8.getClient().getId(), 4);
        assertEquals(response8.getClient().getPriseOrder(), 222400);

    }

    private ClientService getClientService () {
        return appContext.getBean(ClientService.class);
    }
    private ShowOrderService getShowOrderService () {
        return appContext.getBean(ShowOrderService.class);
    }

}
