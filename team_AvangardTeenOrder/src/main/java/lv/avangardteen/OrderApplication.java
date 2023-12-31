package lv.avangardteen;

import lv.avangardteen.UIAction.ProgramMenu;
import lv.avangardteen.config.OrderListConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();
        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printProgramMenu();
            int menuNumber = programMenu.getMenuNumberFromUser();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(OrderListConfiguration.class);
    }
}

