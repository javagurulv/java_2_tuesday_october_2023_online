package lv.javaguru.java2.product.storage;

import lv.javaguru.java2.product.storage.config.SpringCoreConfiguration;
import lv.javaguru.java2.product.storage.console_ui.*;
import lv.javaguru.java2.product.storage.web_ui.config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebProductStorageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);

        ProgramMenu programMenu = context.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printMenu();
            int userChoice = programMenu.getUserMenuChoice();
            programMenu.executeSelectedMenuItem(userChoice);
        }
    }


}

