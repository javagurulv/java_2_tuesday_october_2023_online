package lv.avangardteen.integrationtests;

import lv.avangardteen.config.OrderListConfiguration;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@Ignore
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {OrderListConfiguration.class})
public class SpringContextTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void start() {
        assertNotNull(appContext);
    }

}

