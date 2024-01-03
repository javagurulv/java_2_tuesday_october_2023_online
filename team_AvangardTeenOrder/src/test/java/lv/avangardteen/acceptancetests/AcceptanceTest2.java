package lv.avangardteen.acceptancetests;
/*


import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.request.*;
import lv.avangardteen.core.responce.DeleteOrderResponse;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OrderListConfiguration.class})
@Sql({"/schema.sql"})
public class AcceptanceTest2 {
    private ApplicationContext appContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);

    @Test
    public void shouldDeleteOneOrderData() {
        UserRegistrationRequest request = new UserRegistrationRequest("Alex", 111l, 123456l, "Riga");
        getUserRegistrationService().execute(request);
        UserSizeRegistrationRequest sizeRegistrationRequest = new UserSizeRegistrationRequest(22, 33, 33, 33);
        getUserSizeRegistrationService().execute(sizeRegistrationRequest);
        ComponentRegistrationRequest componentRegistrationRequest = new ComponentRegistrationRequest(11, 21, 31, 41);
        getComponentRegistrationService().execute(componentRegistrationRequest);

        DeleteOrderRequest request3 = new DeleteOrderRequest(1L);
        DeleteOrderResponse response = getDeleteOrderService().execute(request3);
        assertTrue(response.isOrderRemoved());
    }

    private DeleteOrderService getDeleteOrderService () {
        return  appContext.getBean(DeleteOrderService.class);
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
}

*/
