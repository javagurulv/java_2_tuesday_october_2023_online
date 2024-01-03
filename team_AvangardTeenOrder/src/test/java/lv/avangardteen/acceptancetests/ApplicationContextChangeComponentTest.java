package lv.avangardteen.acceptancetests;
/*

import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.*;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.*;
import lv.avangardteen.core.domain.Categories;
import lv.avangardteen.core.domain.Components;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OrderListConfiguration.class})
@Sql({"/schema.sql"})
class ApplicationContextChangeComponentTest {

    @Mock
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void changeComponentTest() {
        UserRegistrationRequest request = new UserRegistrationRequest("Alex", 111l, 123456l, "Riga");
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

        Map<Categories, Components> getMap = wheelchairComponent.getComponents();
        assertEquals(getMap.get(Categories.FRONT_WHEEL).getIndex(), 12);
        assertEquals(getMap.get(Categories.BACK_WHEEL).getIndex(), 22);
        assertEquals(getMap.get(Categories.BRAKE).getIndex(), 32);
        assertEquals(getMap.get(Categories.ARMREST).getIndex(), 42);

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
*/
