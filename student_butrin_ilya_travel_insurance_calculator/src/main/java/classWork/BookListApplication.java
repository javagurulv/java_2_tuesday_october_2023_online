package classWork;
import classWork.consoleUI.*;

import classWork.core.service.AddBookService;

import classWork.core.service.valigators.*;
import classWork.core.service.GetAllBookService;
import classWork.core.service.RemoveBookService;


import java.util.Scanner;

public class BookListApplication {

 ApplicationContext applicationContext = new ApplicationContext();
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
                    AddBookUIAction addBook = applicationContext.getBean(AddBookUIAction.class);
                    addBook.execute();
                    break;
                case (2):
                    RemoveBookUIAction removeBook = applicationContext.getBean(RemoveBookUIAction.class);
                    removeBook.execute();
                    break;
                case (3):
                    GetAllBooksUIAction getbook = applicationContext.getBean(GetAllBooksUIAction.class);
                    getbook.execute();
                    break;
                case (4):
                    SearchBookUIAction searchBook = applicationContext.getBean(SearchBookUIAction.class);
                    searchBook.execute();
                    break;
                case (5):
                    ExitUIAction exit = applicationContext.getBean(ExitUIAction.class);
                    exit.execute();

            }
        }

}
