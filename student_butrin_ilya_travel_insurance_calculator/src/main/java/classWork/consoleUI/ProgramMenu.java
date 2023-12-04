package classWork.consoleUI;

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
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddBookUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, RemoveBookUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, GetAllBooksUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, SearchBookUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, ExitUIAction.class));

    }
    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }
    public static void showMenu () {
        System.out.println("1. добавить книгу в список");
        System.out.println("2. удалить книгу из списка,");
        System.out.println("3. распечатка списка книг на консоль");
        System.out.println("4. поиск книг по автору и/или названию");
        System.out.println("5. выйти из программы");
    }
    public static int selectCategory() {
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        return choose;
    }
    public void executeSelectedMenuItem(int selectedMenu) {
        menuNumberToUIActionMap.get(selectedMenu).execute();
    }
}
