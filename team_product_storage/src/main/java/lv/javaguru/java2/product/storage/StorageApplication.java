package lv.javaguru.java2.product.storage;

import lv.javaguru.java2.product.storage.config.BookListConfiguration;
import lv.javaguru.java2.product.storage.console_ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StorageApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();
        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printMenu();
            int userChoice = programMenu.getUserMenuChoice();
            programMenu.executeSelectedMenuItem(userChoice);
        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }

}

