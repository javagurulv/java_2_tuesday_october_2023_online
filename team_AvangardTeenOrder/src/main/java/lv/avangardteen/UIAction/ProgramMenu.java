package lv.avangardteen.UIAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


@Component
public class ProgramMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public ProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, UserRegistrationUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, UserSizeRegistrationUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, ComponentRegistrationUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, ShowOrderUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, ChangePersonalDateUIAction.class));
        menuNumberToUIActionMap.put(6, findUIAction(uiActions, ChangePersonalSizeUIAction.class));
       // menuNumberToUIActionMap.put(7, findUIAction(uiActions, ChangeComponentsUIAction.class));
         menuNumberToUIActionMap.put(8, findUIAction(uiActions, DeleteOrderUIAction.class));
        menuNumberToUIActionMap.put(9, findUIAction(uiActions, ExitUIAction.class));

    }

    public UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }


    public void printProgramMenu() {
        System.out.println();
        System.out.println("Заказ на инвалидное кресло Avangard Teen");
        System.out.println("1. Регистрация");
        System.out.println("2. Заполнить антропометрические данные");
        System.out.println("3. Выбрать компоненты инвалидного кресла");
        System.out.println("4. Просмотреть бланк заказа");
        System.out.println("5. Внести изменения в личные данные");
        System.out.println("6. Внести изменения в антропометрические данные");
        System.out.println("7. Внести изменения в выборе компонентов");
        System.out.println("8. Удалить заказ");
        System.out.println("9. Согласиться с выбором и выйти из меню");
        System.out.println();
    }

    public int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void executeSelectedMenuItem(int selectedMenu) {
        menuNumberToUIActionMap.get(selectedMenu).execute();
    }
}
