package lv.javaguru.java2.lessoncode.book.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lv.javaguru.java2.lessoncode.book.app.console_ui.ProgramMenu;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import lv.javaguru.java2.lessoncode.book.app.web_ui.config.SpringWebConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebBookListApplication {


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
