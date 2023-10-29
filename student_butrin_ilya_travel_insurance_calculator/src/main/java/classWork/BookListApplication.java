package classWork;
import classWork.consoleUI.*;
import classWork.core.service.AddBookService;
import classWork.core.service.valigators.AddBookValidator;
import classWork.core.service.GetAllBookService;
import classWork.core.service.RemoveBookService;
import classWork.core.service.valigators.RemoveBookValidators;


import java.util.Scanner;

public class BookListApplication {
    Database data = new InMemoryDatabaseImpl();
    AddBookValidator addBookValidator = new AddBookValidator(data);
   RemoveBookValidators removeBookValidator = new RemoveBookValidators();
    UIAction addBook = new AddBookUIAction(new AddBookService(data, addBookValidator));
    UIAction removeBook = new RemoveBookUIAction(new RemoveBookService(data, removeBookValidator));
    UIAction getbook = new GetAllBooksUIAction(new GetAllBookService(data));
    UIAction exit = new ExitUIAction();
    SearchBookValidator searchBookValidator = new SearchBookValidator();
    SearchBooksService searchBooksService = new SearchBooksService(searchBookValidator,data);
    UIAction searchBook = new SearchBookUIAction(searchBooksService);
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
            System.out.println("4. поиск книг по автору и/или названию");
            System.out.println("5. выйти из программы");}
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
                    searchBook.execute();
                    break;
                case (5):
                    exit.execute();

            }
        }
}
