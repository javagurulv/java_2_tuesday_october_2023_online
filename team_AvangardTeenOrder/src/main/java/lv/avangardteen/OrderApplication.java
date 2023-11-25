package lv.avangardteen;

import lv.avangardteen.UIAction.*;
import lv.avangardteen.config.OrderListConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class OrderApplication {
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(OrderListConfiguration.class);


    public static void main(String[] args) {

        while (true) {
            printProgramMenu();
            int menuNumber = getMenuNumberFromUser();
            executeSelectedMenuItem(menuNumber);
        }
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printProgramMenu() {
        System.out.println();
        System.out.println("Заказ на инвалидное кресло Avangard Teen");
        System.out.println("1. Оформить бланк заказа");
        System.out.println("2. Просмотреть бланк заказа");
        System.out.println("3. Внести изменения в личные данные");
        System.out.println("4. Внести изменения в антропометрические данные");
        System.out.println("5. Внести изменения в выборе компонентов");
        System.out.println("6. Удалить заказ");
        System.out.println("7. Согласиться с выбором и выйти из меню");
        System.out.println();
    }

    private static void executeSelectedMenuItem(int selectedMenu) {

        switch (selectedMenu) {
            case (1): {
                OrderUIAction uiAction = applicationContext.getBean(OrderUIAction.class);
                uiAction.execute();
                break;
            }
            case (2): {
                ShowOrderUIAction uiAction = applicationContext.getBean(ShowOrderUIAction.class);
                uiAction.execute();
                break;
            }
            case (3): {
                ChangePersonalDateUIAction uiAction = applicationContext.getBean(ChangePersonalDateUIAction.class);
                uiAction.execute();
                break;
            }
            case (4): {
                ChangePersonalSizeUIAction uiAction = applicationContext.getBean(ChangePersonalSizeUIAction.class);
                uiAction.execute();
                break;
            }
            case (5): {
                ChangeComponentsUIAction uiAction = applicationContext.getBean(ChangeComponentsUIAction.class);
                uiAction.execute();
                break;
            }
            case (6): {
                DeleteOrderUIAction uiAction = applicationContext.getBean(DeleteOrderUIAction.class);
                uiAction.execute();
                break;
            }
            case (7): {
                ExitUIAction uiAction = applicationContext.getBean(ExitUIAction.class);
                uiAction.execute();
                break;
            }
        }
    }
}

