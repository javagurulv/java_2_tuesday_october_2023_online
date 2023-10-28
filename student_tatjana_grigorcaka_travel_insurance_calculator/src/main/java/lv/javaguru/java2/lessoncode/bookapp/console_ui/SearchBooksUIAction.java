package lv.javaguru.java2.lessoncode.bookapp.console_ui;

import lv.javaguru.java2.lessoncode.bookapp.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.bookapp.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.bookapp.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.bookapp.core.services.SearchBooksService;

import java.util.Scanner;


public class SearchBooksUIAction implements UIAction{

    private SearchBooksService searchBooksService;

    public SearchBooksUIAction(SearchBooksService searchBooksService) {
        this.searchBooksService = searchBooksService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        System.out.println("Enter book author: ");
        String author = scanner.nextLine();

        System.out.println("Enter orderBy (title||author): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        SearchBooksRequest request = new SearchBooksRequest(title, author);
        SearchBooksResponse response = searchBooksService.execute(request);

        if (response.containsErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getErrorMessage()));
        } else {
            response.getBooks().forEach(System.out::println);
        }
    }

}
