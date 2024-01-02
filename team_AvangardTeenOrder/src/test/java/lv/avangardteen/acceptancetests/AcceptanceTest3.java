package lv.avangardteen.acceptancetests;
/*


import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.*;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Ignore

public class AcceptanceTest3 {
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void shouldChangeOneOrderPersonalDataAndChangeSecondOrderPersonalSize() {
        UserRegistrationRequest request = new UserRegistrationRequest("Alex", 111l, 123456l, "Riga");
        getUserRegistrationService().execute(request);
        UserSizeRegistrationRequest sizeRegistrationRequest = new UserSizeRegistrationRequest(22, 33, 33, 33);
        getUserSizeRegistrationService().execute(sizeRegistrationRequest);
        ComponentRegistrationRequest componentRegistrationRequest = new ComponentRegistrationRequest(11, 21, 31, 41);
        getComponentRegistrationService().execute(componentRegistrationRequest);

        ShowOrderRequest showOrderRequest = new ShowOrderRequest(1l);
        ShowOrderResponse response = getShowOrderService().execute(showOrderRequest);

        ChangePersonalDateRequest request4 = new ChangePersonalDateRequest(1l, "AlexNew", 111l,
                654321l, "NewRiga");
        getChangePersonalDateService().execute(request4);

        ShowOrderRequest showOrderRequest1 = new ShowOrderRequest(1l);
        ShowOrderResponse response5 = getShowOrderService().execute(showOrderRequest1);


        UserRegistrationRequest request1 = new UserRegistrationRequest("Alex", 111l,  123456l, "Riga");
        getUserRegistrationService().execute(request1);
        UserSizeRegistrationRequest sizeRegistrationRequest1 = new UserSizeRegistrationRequest(22, 33, 33, 33);
        getUserSizeRegistrationService().execute(sizeRegistrationRequest1);
        ComponentRegistrationRequest componentRegistrationRequest1 = new ComponentRegistrationRequest(11, 21, 31, 41);
        getComponentRegistrationService().execute(componentRegistrationRequest1);

        ChangePersonalSizeRequest request5 = new ChangePersonalSizeRequest(2L, 55,
                12, 13, 14);
        getChangePersonalSizeService().execute(request5);

        ShowOrderRequest showOrderRequest2 = new ShowOrderRequest(2l);
        ShowOrderResponse response7 = getShowOrderService().execute(showOrderRequest2);


        assertEquals(response.getClient().getId(), 1);
        assertEquals(response.getClient().getNameSurname(), "Alex");
        assertEquals(response.getClient().getPhone(), 123456l);
        assertEquals(response.getClient().getAddress(), "Riga");
        assertEquals(response.getUserSizes().getId(), 1);
        assertEquals(response.getUserSizes().getShinLength(), 33);
        assertEquals(response.getUserSizes().getBackHeight(), 33);
        assertEquals(response.getUserSizes().getThighLength(), 33);
        assertEquals(response.getUserSizes().getPelvisWidth(), 22);

        assertEquals(response5.getClient().getId(), 1l);
        assertEquals(response5.getClient().getNameSurname(), "AlexNew");
        assertEquals(response5.getClient().getPhone(), 654321l);
        assertEquals(response5.getClient().getAddress(), "NewRiga");
        assertEquals(response5.getUserSizes().getShinLength(), 33);
        assertEquals(response5.getUserSizes().getBackHeight(), 33);
        assertEquals(response5.getUserSizes().getThighLength(), 33);
        assertEquals(response5.getUserSizes().getPelvisWidth(), 22);

        assertEquals(response7.getClient().getId(), 2l);
        assertEquals(response7.getClient().getNameSurname(), "Alex");
        assertEquals(response7.getClient().getPhone(), 123456);
        assertEquals(response7.getClient().getAddress(), "Riga");
        assertEquals(response7.getUserSizes().getShinLength(), 14);
        assertEquals(response7.getUserSizes().getBackHeight(), 13);
        assertEquals(response7.getUserSizes().getThighLength(), 12);
        assertEquals(response7.getUserSizes().getPelvisWidth(), 55);

    }

    private UserRegistrationService getUserRegistrationService() {
        return appContext.getBean(UserRegistrationService.class);
    }

    private UserSizeRegistrationService getUserSizeRegistrationService() {
        return appContext.getBean(UserSizeRegistrationService.class);
    }

    private ComponentRegistrationService getComponentRegistrationService() {
        return appContext.getBean(ComponentRegistrationService.class);
    }

    private ChangePersonalSizeService getChangePersonalSizeService() {
        return appContext.getBean(ChangePersonalSizeService.class);
    }

    private ChangePersonalDateService getChangePersonalDateService() {
        return appContext.getBean(ChangePersonalDateService.class);
    }

    private ShowOrderService getShowOrderService() {
        return appContext.getBean(ShowOrderService.class);
    }

}

*/
