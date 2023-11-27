package lv.javaguru.java2.lessoncode.book.app;

import lv.javaguru.java2.lessoncode.book.app.config.BookListConfiguration;
import lv.javaguru.java2.lessoncode.book.app.console_ui.ProgramMenu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookListApplication {


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

