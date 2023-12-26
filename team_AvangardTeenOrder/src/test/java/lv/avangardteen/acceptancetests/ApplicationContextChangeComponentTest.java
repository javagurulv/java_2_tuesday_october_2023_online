package lv.avangardteen.acceptancetests;

import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.*;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.*;
import lv.avangardteen.core.domain.Category;
import lv.avangardteen.core.domain.Components;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationContextChangeComponentTest {

    @Mock
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void changeComponentTest() {
        UserRegistrationRequest request = new UserRegistrationRequest("Alex", 123456l, "Riga");
        getUserRegistrationService().execute(request);
        UserSizeRegistrationRequest sizeRegistrationRequest = new UserSizeRegistrationRequest(22, 33, 33, 33);
        getUserSizeRegistrationService().execute(sizeRegistrationRequest);
        ComponentRegistrationRequest componentRegistrationRequest = new ComponentRegistrationRequest(11, 21, 31, 41);
        getComponentRegistrationService().execute(componentRegistrationRequest);

        ChangeComponentRequest request1 = new ChangeComponentRequest(1l, 12, 22, 32, 42);

        ChangeComponentResponse response = getChangeComponentService().execute(request1);
        ShowOrderRequest request2 = new ShowOrderRequest(1l);
        ShowOrderResponse response1  = getShowOrderService().execute(request2);
        WheelchairComponent wheelchairComponent = response1.getWheelchairComponent();

        Map<Category, Components> getMap = wheelchairComponent.getComponents();
        assertEquals(getMap.get(Category.FRONT_WHEEL).getIndex(), 12);
        assertEquals(getMap.get(Category.BACK_WHEEL).getIndex(), 22);
        assertEquals(getMap.get(Category.BRAKE).getIndex(), 32);
        assertEquals(getMap.get(Category.ARMREST).getIndex(), 42);

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
