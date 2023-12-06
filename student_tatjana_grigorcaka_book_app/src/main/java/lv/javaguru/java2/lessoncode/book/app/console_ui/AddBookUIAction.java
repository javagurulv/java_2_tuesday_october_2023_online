package lv.javaguru.java2.lessoncode.book.app.console_ui;

import java.util.List;
import java.util.Scanner;

import lv.javaguru.java2.lessoncode.book.app.core.services.GetGenreChoiceService;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetGenresListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;


@Component
public class AddBookUIAction implements UIAction {

    @Autowired
    private AddBookService addBookService;
    @Autowired
    private GetGenresListService getGenresListService;
    @Autowired
    private GetGenreChoiceService getGenreChoiceService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        System.out.println("Enter book issue year: ");
        Integer issueYear = scanner.nextInt();
        System.out.println("Select book genre:");
        List<String> genres = getGenresListService.getGenresList();
        Genre selectedGenre = getGenreChoiceService.getGenreChoice(scanner, genres);

        AddBookRequest request = new AddBookRequest(bookTitle, bookAuthor, issueYear, selectedGenre);
        AddBookResponse response = addBookService.execute(request);
        if (response.containsErrors()) {
            for (CoreError error : response.getErrors()) {
                System.out.println("Error: " + error.getErrorCode() + " " + error.getErrorMessage());
            }
        } else {
            System.out.println("New book id was: " + response.getNewBook().getId());
            System.out.println("Your book was added to the list: ");
        }
    }

}








