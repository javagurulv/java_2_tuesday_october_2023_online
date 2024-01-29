package classWork;
import classWork.consoleUI.*;

//import classWork.dependency_injection.DIApplicationContextBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import java.util.Scanner;

public class BookListApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
              createApplicationContext();
        ProgramMenu menu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            menu.showMenu();
            int menuNumber = menu.selectCategory();
            menu.executeSelectedMenuItem(menuNumber);
        }
    }
    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }
}
