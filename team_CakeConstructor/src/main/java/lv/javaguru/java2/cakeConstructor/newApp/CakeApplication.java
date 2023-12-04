package lv.javaguru.java2.cakeConstructor.newApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.cakeConstructor.newApp.config.CakeConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.console_ui.*;


public class CakeApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();
        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printProgramMenu();
            int userChoice = programMenu.getUserChoice();
            programMenu.executeSelectedMenuItem(userChoice);

        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(CakeConfiguration.class);
    }
}


