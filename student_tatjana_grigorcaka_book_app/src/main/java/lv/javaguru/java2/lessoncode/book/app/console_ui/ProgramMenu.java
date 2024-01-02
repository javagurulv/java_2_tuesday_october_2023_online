package lv.javaguru.java2.lessoncode.book.app.console_ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgramMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public ProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddBookUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, RemoveBookUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, PrintAllBooksUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, SearchBooksUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, RegisterReaderUIAction.class));
        menuNumberToUIActionMap.put(6, findUIAction(uiActions, PrintAllReadersUIAction.class));
        menuNumberToUIActionMap.put(7, findUIAction(uiActions, ProgramExitUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Add book to list");
        System.out.println("2. Delete book from list");
        System.out.println("3. Show all books in the list");
        System.out.println("4. Search books");
        System.out.println("5. Register reader");
        System.out.println("6. Show all readers in the list");
        System.out.println("7. Exit program");
        System.out.println();
    }

    public int getUserMenuChoice() {
        System.out.println("Enter menu item number to execute ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) { menuNumberToUIActionMap.get(selectedMenu).execute(); }

}
