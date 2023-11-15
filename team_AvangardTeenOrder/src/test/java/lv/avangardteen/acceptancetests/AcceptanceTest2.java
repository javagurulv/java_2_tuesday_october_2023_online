package lv.avangardteen.acceptancetests;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.core.service.DeleteOrderService;
import lv.avangardteen.core.service.ShowOrderService;
import lv.avangardteen.dependency_injection.ApplicationContext;
import lv.avangardteen.dependency_injection.DIApplicationContextBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AcceptanceTest2 {
    private ApplicationContext appContext = new DIApplicationContextBuilder().build("lv.avangardteen");

    @Test
    public void shouldDeleteOneOrderData() {
        ClientRequest request1 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                 31, 41);
        getClientService().execute(request1);

        ClientRequest request2 = new ClientRequest("Olga", 54321, "Tallin",
                11,21, 31, 41, 17,21,
                31, 41);
        getClientService().execute(request2);

        DeleteOrderRequest request3 = new DeleteOrderRequest(1L);
        getDeleteOrderService().execute(request3);

        ShowOrderResponse response = getShowOrderService().execute(new ShowOrderRequest(1L));

        ShowOrderResponse response2 = getShowOrderService().execute(new ShowOrderRequest(2L));

        assertNull(response.getClient());

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

    private DeleteOrderService getDeleteOrderService () {
        return  appContext.getBean(DeleteOrderService.class);
    }

    private ShowOrderService getShowOrderService () {
        return appContext.getBean(ShowOrderService.class);
    }

}
