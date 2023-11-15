package lv.avangardteen.acceptancetests;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ChangePersonalDateService;
import lv.avangardteen.core.service.ChangePersonalSizeService;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.core.service.ShowOrderService;
import lv.avangardteen.dependency_injection.ApplicationContext;
import lv.avangardteen.dependency_injection.DIApplicationContextBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest3 {
    private ApplicationContext appContext = new DIApplicationContextBuilder().build("lv.avangardteen");

    @Test
    public void shouldChangeOneOrderPersonalDataAndChangeSecondOrderPersonalSize() {
        ClientRequest request1 = new ClientRequest("Alex", 123456, "Riga", 11,
                22, 33, 44, 11, 21,
                 31, 41);
        getClientService().execute(request1);

        ClientRequest request2 = new ClientRequest("Olga", 54321, "Tallin",
                11,21, 31, 41, 17,21,
                31, 41);
        getClientService().execute(request2);

        ChangePersonalDateRequest request4 = new ChangePersonalDateRequest(1L, "AlexNew",
                654321, "NewRiga");
        getChangePersonalDateService().execute(request4);

        ChangePersonalSizeRequest request5 = new ChangePersonalSizeRequest(2L,55,
                12,13,14);
        getChangePersonalSizeService().execute(request5);

        ShowOrderResponse response = getShowOrderService().execute(new ShowOrderRequest(1L));

        ShowOrderResponse response2 = getShowOrderService().execute(new ShowOrderRequest(2L));

        assertEquals(response.getClient().getId(), 1);
        assertEquals(response.getClient().getNameSurname(), "AlexNew");
        assertEquals(response.getClient().getPhoneNumber(), 654321);
        assertEquals(response.getClient().getUserAddress(), "NewRiga");
        assertEquals(response.getClient().getUserSizes().getShinLength(), 11);
        assertEquals(response.getClient().getUserSizes().getBackHeight(), 22);
        assertEquals(response.getClient().getUserSizes().getThighLength(), 33);
        assertEquals(response.getClient().getUserSizes().getPelvisWidth(), 44);

        assertEquals(response2.getClient().getId(), 2);
        assertEquals(response2.getClient().getNameSurname(), "Olga");
        assertEquals(response2.getClient().getPhoneNumber(), 54321);
        assertEquals(response2.getClient().getUserAddress(), "Tallin");
        assertEquals(response2.getClient().getUserSizes().getShinLength(), 14);
        assertEquals(response2.getClient().getUserSizes().getBackHeight(), 13);
        assertEquals(response2.getClient().getUserSizes().getThighLength(), 12);
        assertEquals(response2.getClient().getUserSizes().getPelvisWidth(), 55);

    }

    private ClientService getClientService () {
        return appContext.getBean(ClientService.class);
    }
    private ChangePersonalSizeService getChangePersonalSizeService () {
        return  appContext.getBean(ChangePersonalSizeService.class);
    }

    private ChangePersonalDateService getChangePersonalDateService () {
        return  appContext.getBean(ChangePersonalDateService.class);
    }
    private ShowOrderService getShowOrderService () {
        return appContext.getBean(ShowOrderService.class);
    }

}
