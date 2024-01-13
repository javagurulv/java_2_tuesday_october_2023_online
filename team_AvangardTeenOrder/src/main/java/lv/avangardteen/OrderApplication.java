package lv.avangardteen;

import lv.avangardteen.UIAction.ProgramMenu;
import lv.avangardteen.config.SpringCoreConfiguration;
import lv.avangardteen.web_ui.config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class OrderApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);
        ProgramMenu programMenu = context.getBean(ProgramMenu.class);
/*
        while (true) {
            programMenu.printProgramMenu();
            int menuNumber = programMenu.getMenuNumberFromUser();
            programMenu.executeSelectedMenuItem(menuNumber);
        }*/
    }

   /* private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
    }*/
}

