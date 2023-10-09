package lv.javaguru.travel.insurance;

import java.security.PublicKey;
import java.util.List;
import java.util.Scanner;

public class BookListApplication {
    DataBook data = new DataBook();
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
                    addBook();
                    break;
                case (2):
                    removeBook();
                    break;
                case (3):
                    showAllBooks();
                    break;
                case (4):
                    finishProgram();

            }
        }
            private void addBook() {
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите автора");
                String author = scan.nextLine();
                System.out.println("Введите название книги");
                String title = scan.nextLine();
                Book book = new Book(author, title);
                data.addBook(book);
            }
            private void removeBook(){
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите автора");
                String author = scan.nextLine();
                System.out.println("Введите название книги");
                String title = scan.nextLine();
                Book book = new Book(author, title);
                data.deleteBook(book);
        }
        private  void showAllBooks (){
            List<Book> books = data.getBooks();
            for (Book bookFromList : books)
                System.out.println(bookFromList.getAuthor() + "  " + bookFromList.getTitle());
        }
        private void finishProgram () {
        System.out.println("Good BYE");
        System.exit(0);
        }
}
