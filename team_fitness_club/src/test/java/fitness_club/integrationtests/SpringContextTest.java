package fitness_club.integrationtests;

import static org.junit.Assert.assertNotNull;
import fitness_club.config.ClientWorkoutsConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientWorkoutsConfiguration.class})

public class SpringContextTest {
    @Autowired private ApplicationContext applicationContext;

    @Test
    public void start() {
        assertNotNull(applicationContext);
    }
}
