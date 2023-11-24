package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class AddBookUIAction implements UIAction {

    @DIDependency
    private AddBookService addBookService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();

        System.out.println("Select book genre: ");
        while (true) {
            System.out.println("Offered book genres:");
            Genre[] genres = getGenresList();
            System.out.println("0. Exit");

            System.out.print("Enter book genre ID or 0 to exit: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice < 1 || choice > genres.length) {
                System.out.println("Invalid choice. Please try again");
                continue;
            }
            Genre selectedGenre = genres[choice - 1];

            AddBookRequest request = new AddBookRequest(bookTitle, bookAuthor, selectedGenre);
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

    private static Genre[] getGenresList() {
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + ". " + genres[i]);
        }
        return genres;
    }
}


