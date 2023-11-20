package lv.avangardteen.acceptancetests;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.core.service.ShowOrderService;
import lv.avangardteen.dependency_injection.ApplicationContext;
import lv.avangardteen.dependency_injection.DIApplicationContextBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest7 {
    private ApplicationContext appContext = new DIApplicationContextBuilder().build("lv.avangardteen");

    @Test
    public void shouldReturnErrorsFromOneOrderAndReturnDataFromSecondOrder() {
        ClientRequest request = new ClientRequest("", null, "", 0,
                0, 0, 0, 0, 0,
                 0, 0);
        getClientService().execute(request);

        ClientRequest request2 = new ClientRequest("Olga", 54321, "Tallin",
                11,21, 31, 41, 17,21,
                31, 41);
        getClientService().execute(request2);

        ClientResponse response = getClientService().execute(request);

        ShowOrderResponse response2 = getShowOrderService().execute(new ShowOrderRequest(1L));

        assertEquals(response.getErrors().size(), 11);
        assertEquals(response.getErrors().get(0), (new CoreError("surname", "Must not be empty!")));
        assertEquals(response.getErrors().get(1), (new CoreError("phone", "Must not be empty!")));
        assertEquals(response.getErrors().get(2), (new CoreError("address", "Must not be empty!")));
        assertEquals(response.getErrors().get(3), (new CoreError("pelvisWidth", "Must not be empty!")));
        assertEquals(response.getErrors().get(4), (new CoreError("thighLength", "Must not be empty!")));
        assertEquals(response.getErrors().get(5), (new CoreError("backHeight", "Must not be empty!")));
        assertEquals(response.getErrors().get(6), (new CoreError("shinLength", "Must not be empty!")));
        assertEquals(response.getErrors().get(7), (new CoreError("indexFrontWheel", "This index is absent!")));
        assertEquals(response.getErrors().get(8), (new CoreError("indexBackWheel", "This index is absent!")));
        assertEquals(response.getErrors().get(9), (new CoreError("indexBrake", "This index is absent!")));
        assertEquals(response.getErrors().get(10), (new CoreError("indexArmrest", "This index is absent!")));

        assertEquals(response2.getClient().getId(), 1);
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
