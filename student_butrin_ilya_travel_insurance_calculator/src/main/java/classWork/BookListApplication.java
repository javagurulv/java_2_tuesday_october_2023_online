package classWork;
import classWork.consoleUI.*;


import java.util.Scanner;

public class BookListApplication {
    Database data = new InMemoryDatabaseImpl();
    UIAction addBook = new AddBookUIAction(data);
    UIAction removeBook = new RemoveBookUIAction(data);
    UIAction getbook = new GetAllBooksUIAction(data);
    UIAction exit = new ExitUIAction();
    public static void main(String[] args) {

        BookListApplication bookListApplication = new BookListApplication();
        while (true) {
           showMenu();
            int choose = selectСategory();
            bookListApplication.executeMenu(choose);
        }
    }
        public static void showMenu () {
            System.out.println("1. добавить книгу в список");
            System.out.println("2. удалить книгу из списка,");
            System.out.println("3. распечатка списка книг на консоль");
            System.out.println("4. выйти из программы");}
        public static int selectСategory (){
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        return choose;
    }
        public void executeMenu(int choose) {

            switch (choose) {
                case (1):
                    addBook.execute();
                    break;
                case (2):
                    removeBook.execute();
                    break;
                case (3):
                    getbook.execute();
                    break;
                case (4):
                    exit.execute();

            }
        }
}
