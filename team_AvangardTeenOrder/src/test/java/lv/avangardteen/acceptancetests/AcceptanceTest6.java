package lv.avangardteen.acceptancetests;


import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.*;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest6 {
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void checkPriceOfDifferentArmrest() {
        UserRegistrationRequest request = new UserRegistrationRequest("Alex", 111l, 123456l, "Riga");
        getUserRegistrationService().execute(request);
        UserSizeRegistrationRequest sizeRegistrationRequest = new UserSizeRegistrationRequest(22, 33, 33, 33);
        getUserSizeRegistrationService().execute(sizeRegistrationRequest);
        ComponentRegistrationRequest componentRegistrationRequest = new ComponentRegistrationRequest(11, 21, 31, 41);
        getComponentRegistrationService().execute(componentRegistrationRequest);
        ShowOrderRequest showOrderRequest = new ShowOrderRequest(1l);
        ShowOrderResponse response = getShowOrderService().execute(showOrderRequest);



        ChangeComponentRequest request1 = new ChangeComponentRequest(1l, 12, 22, 32, 42);
        getChangeComponentService().execute(request1);
        ShowOrderRequest showOrderRequest2 = new ShowOrderRequest(1l);
        ShowOrderResponse response3 = getShowOrderService().execute(showOrderRequest2);

        assertEquals(response.getClient().getId(), 1);
        assertEquals(response.getWheelchairComponent().countPriceOrder(), 199700.0);


        assertEquals(response3.getClient().getId(), 1);
        assertEquals(response3.getWheelchairComponent().countPriceOrder(), 205000.0);

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

    private ChangeComponentService getChangeComponentService() {
        return  appContext.getBean(ChangeComponentService.class);
    }

    private ShowOrderService getShowOrderService() {
        return appContext.getBean(ShowOrderService.class);
    }

}

