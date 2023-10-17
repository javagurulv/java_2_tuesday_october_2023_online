package classWork.consoleUI;

import classWork.Database;
import classWork.InMemoryDatabaseImpl;

import java.util.Scanner;

public class RemoveBookUIAction implements UIAction {
    Database data = new InMemoryDatabaseImpl();

    public RemoveBookUIAction(Database data) {
        this.data = data;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер книги, который хотите удалить");
        Long deleteId = Long.parseLong(scan.nextLine());
        data.deleteBook(deleteId);
    }
}
