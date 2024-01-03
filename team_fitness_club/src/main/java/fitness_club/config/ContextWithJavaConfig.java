package fitness_club.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fitness_club.core.database.jpa")
public class ContextWithJavaConfig {
}
