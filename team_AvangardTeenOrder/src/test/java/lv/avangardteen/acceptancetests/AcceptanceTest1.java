package lv.avangardteen.acceptancetests;


import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.request.UserSizeRegistrationRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ComponentRegistrationService;
import lv.avangardteen.core.service.ShowOrderService;
import lv.avangardteen.core.service.UserRegistrationService;
import lv.avangardteen.core.service.UserSizeRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest1 {
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void shouldReturnOrderData() {
        UserRegistrationRequest request = new UserRegistrationRequest("Alex", 123456l, "Riga");
        getUserRegistrationService().execute(request);
        UserSizeRegistrationRequest sizeRegistrationRequest = new UserSizeRegistrationRequest(22, 33, 33, 33);
        getUserSizeRegistrationService().execute(sizeRegistrationRequest);
        ComponentRegistrationRequest componentRegistrationRequest = new ComponentRegistrationRequest(11, 21, 31, 41);
        getComponentRegistrationService().execute(componentRegistrationRequest);
        ShowOrderRequest showOrderRequest = new ShowOrderRequest(1l);
        ShowOrderResponse response = getShowOrderService().execute(showOrderRequest);

        assertEquals(response.getClient().getId(), 1);
        assertEquals(response.getClient().getNameSurname(), "Alex");
        assertEquals(response.getClient().getPhoneNumber(), 123456l);
        assertEquals(response.getClient().getUserAddress(), "Riga");
        assertEquals(response.getUserSizes().getId(), 1);
        assertEquals(response.getUserSizes().getShinLength(), 33);
        assertEquals(response.getUserSizes().getBackHeight(), 33);
        assertEquals(response.getUserSizes().getThighLength(), 33);
        assertEquals(response.getUserSizes().getPelvisWidth(), 22);
        assertEquals(response.getWheelchair().getId(), 1);
        assertEquals(response.getWheelchair().getBachHeight(), 33);
        assertEquals(response.getWheelchair().getFootrestLength(), 40);
        assertEquals(response.getWheelchair().getSeatDepth(), 32);
        assertEquals(response.getWheelchair().getSeatWidth(), 26);
        assertEquals(response.getWheelchairComponent().getId(), 1);
        assertEquals(response.getWheelchairComponent().getPriceWheelchair(), 177000.0);
        assertEquals(response.getWheelchairComponent().getComponents().size(), 4);
        assertEquals(response.getWheelchairComponent().countPriceOrder(), 199700.0);


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

    private ShowOrderService getShowOrderService() {
        return appContext.getBean(ShowOrderService.class);
    }
}

