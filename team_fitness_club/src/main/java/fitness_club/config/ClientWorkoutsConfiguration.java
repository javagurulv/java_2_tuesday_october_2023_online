package fitness_club.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "fitness_club")
@PropertySource(value = "classpath:application.properties")
public class ClientWorkoutsConfiguration {
}
