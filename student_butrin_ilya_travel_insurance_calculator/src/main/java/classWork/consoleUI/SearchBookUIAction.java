package classWork.consoleUI;

import classWork.Book;
import classWork.core.requests.Ordering;
import classWork.core.requests.Paging;
import classWork.core.response.SearchBooksResponse;
import classWork.core.CoreError;
import classWork.core.requests.SearchBooksRequest;
import classWork.core.service.SearchBooksService;

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
        System.out.println("Выберете тип сортировки");
        System.out.println("по автору / по названию");
        String orderBy = scan.nextLine();
        System.out.println("по убыванию / по возростанию");
        String orderDiscript = scan.nextLine();
        System.out.println("Сколько книг вы хотитег видеть на странице?");
        Integer pageSize = Integer.parseInt(scan.nextLine());
        System.out.println("на какую страницу перейти?");
        Integer pageNumber = Integer.parseInt(scan.nextLine());
        Ordering ordering = new Ordering(orderBy, orderDiscript);
        Paging paging = new Paging(pageNumber,pageSize);
        SearchBooksRequest request = new SearchBooksRequest(author, title, paging, ordering);
        SearchBooksResponse responce = servis.searchAndSort(request);
        if (responce.hasErrors()) {
            List<CoreError> errorlist = responce.getErrors();
            for (CoreError error : errorlist) {
                System.err.println("ОШИБКА: " + error.getField() + " " + error.getMessage());
            }
        } else {
           responce.getBookSearch().forEach(b ->  System.out.println(b.getAuthor() + " название: " + b.getTitle()));
        }
    }
}
