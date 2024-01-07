package avangardteen.java2app;
import avangardteen.java2app.UIAction.*;
import avangardteen.java2app.dependency_injection.DIApplicationContextBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
public class
App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = applicationContext();
        while (true) {
            ProgramMenu menu = applicationContext.getBean(ProgramMenu.class);
            menu.showMenu();
            menu.executeSelectedMenuItem(menu.selectNumber());
        }
    }
        private static ApplicationContext applicationContext () {
         return new AnnotationConfigApplicationContext(AppConfiguration.class);
        }

    }

