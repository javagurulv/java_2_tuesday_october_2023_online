package classWork;

import classWork.consoleUI.UIAction;
import classWork.core.CoreError;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import java.util.List;
import java.util.Scanner;

public class SearchBookUIAction implements UIAction {
    SearchBooksService servis;

    public SearchBookUIAction(SearchBooksService servis) {
        this.servis = servis;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите автора книги (оставте поле пустым, если поиск книги будет только по названию)");
        String author = scan.nextLine();
        System.out.println("Введите название книги (оставте поле пустым, если поиск книги будет только по автору)");
        String title = scan.nextLine();
        SearchBooksRequest request = new SearchBooksRequest(author, title);
        SearchBooksResponse responce = servis.searchBook(request);
        if (responce.hasErrors()) {
            List<CoreError> errorlist = responce.getErrors();
            for (CoreError error : errorlist) {
                System.err.println("ОШИБКА: " + error.getField() + " " + error.getMessage());
            }
        } else {
            List<Book> books = responce.getBookSearch();
            for (Book book : books)
                System.out.println(book.getAuthor() + " название: " + book.getTitle());
        }
    }
}