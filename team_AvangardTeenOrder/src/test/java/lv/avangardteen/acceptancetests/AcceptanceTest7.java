package lv.avangardteen.acceptancetests;


import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.request.UserSizeRegistrationRequest;
import lv.avangardteen.core.responce.*;
import lv.avangardteen.core.service.ComponentRegistrationService;
import lv.avangardteen.core.service.ShowOrderService;
import lv.avangardteen.core.service.UserRegistrationService;
import lv.avangardteen.core.service.UserSizeRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest7 {
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void shouldReturnErrorsFromOneOrderAndReturnDataFromSecondOrder() {

        UserRegistrationRequest request = new UserRegistrationRequest("", 111l, null, "");
        UserRegistrationResponse response = getUserRegistrationService().execute(request);
        UserSizeRegistrationRequest sizeRegistrationRequest = new UserSizeRegistrationRequest(0, null, 0, 0);
        UserSizeRegistrationResponse response1 = getUserSizeRegistrationService().execute(sizeRegistrationRequest);
        ComponentRegistrationRequest componentRegistrationRequest = new ComponentRegistrationRequest(3, 2, 1, 5);
        ComponentRegistrationResponse response2 = getComponentRegistrationService().execute(componentRegistrationRequest);


        assertEquals(response.getErrors().size(), 3);
        assertEquals(response.getErrors().get(0), (new CoreError("surname", "Must not be empty!")));
        assertEquals(response.getErrors().get(1), (new CoreError("phone", "Must not be empty!")));
        assertEquals(response.getErrors().get(2), (new CoreError("address", "Must not be empty!")));

        assertEquals(response1.getErrors().size(), 4);
        assertEquals(response1.getErrors().get(0), (new CoreError("pelvisWidth", "Must not be empty!")));
        assertEquals(response1.getErrors().get(1), (new CoreError("thighLength", "Must not be empty!")));
        assertEquals(response1.getErrors().get(2), (new CoreError("backHeight", "Must not be empty!")));
        assertEquals(response1.getErrors().get(3), (new CoreError("shinLength", "Must not be empty!")));

        assertEquals(response2.getErrors().size(), 4);
        assertEquals(response2.getErrors().get(0), (new CoreError("indexFrontWheel", "This index is absent!")));
        assertEquals(response2.getErrors().get(1), (new CoreError("indexBackWheel", "This index is absent!")));
        assertEquals(response2.getErrors().get(2), (new CoreError("indexBrake", "This index is absent!")));
        assertEquals(response2.getErrors().get(3), (new CoreError("indexArmrest", "This index is absent!")));


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

