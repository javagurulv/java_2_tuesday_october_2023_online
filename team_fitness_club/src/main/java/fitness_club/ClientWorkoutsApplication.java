package fitness_club;

import fitness_club.config.ClientWorkoutsConfiguration;
import fitness_club.console_UI.ProgramMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ClientWorkoutsApplication {


    public static void main(String[] args) {

        ApplicationContext applicationContext = createApplicationContext();

        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);

        while (true) {
            programMenu.printProgramMenu();
            int menuNumber = programMenu.getMenuNumber();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(ClientWorkoutsConfiguration.class);
    }
}
