package lv.javaguru.java2.cakeConstructor.newApp;

import lv.javaguru.java2.cakeConstructor.newApp.web_ui.config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.cakeConstructor.newApp.config.SpringCoreConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.console_ui.*;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebCakeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);

        ProgramMenu programMenu = context.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printProgramMenu();
            int userChoice = programMenu.getUserChoice();
            programMenu.executeSelectedMenuItem(userChoice);

        }
    }

}


