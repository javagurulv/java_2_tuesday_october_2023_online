package lv.javaguru.java2.lessoncode.book.app.console_ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.InputMismatchException;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;


@Component
public class AddBookUIAction implements UIAction {

    @Autowired
    private AddBookService addBookService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        System.out.println("Enter book issue year: ");
        Integer issueYear = getIssueYear(scanner);

        System.out.println("Select book genre:");
        Genre[] genres = getGenresList();
        Genre selectedGenre = getGenreChoice(scanner, genres);

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


    private static Integer getIssueYear(Scanner scanner) {
        Integer issueYear = null;
        while (issueYear == null) {
            try {
                issueYear = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the issue year.");
                scanner.next();
            }
        }
        return issueYear;
    }

    private static Genre[] getGenresList() {
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + ". " + genres[i]);
        }
        return genres;
    }


    private static Genre getGenreChoice(Scanner scanner, Genre[] genres) {

        System.out.println("Enter the number corresponding to the desired genre:");

        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= genres.length) {
                    Genre selectedGenre = genres[choice - 1];
                    System.out.println("You selected: " + selectedGenre);
                    return selectedGenre;
                } else {
                    System.out.println("Please enter a valid genre number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid genre number.");
                scanner.next();
            }
        }
    }
}







