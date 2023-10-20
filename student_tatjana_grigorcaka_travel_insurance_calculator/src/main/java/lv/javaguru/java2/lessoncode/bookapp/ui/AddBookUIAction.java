package lv.javaguru.java2.lessoncode.bookapp.ui;

import lv.javaguru.java2.lessoncode.bookapp.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.bookapp.responses.AddBookResponse;
import lv.javaguru.java2.lessoncode.bookapp.responses.CoreError;
import lv.javaguru.java2.lessoncode.bookapp.services.AddBookService;

import java.util.Scanner;

public class AddBookUIAction  implements UIAction {

    private AddBookService addBookService;

    public AddBookUIAction(AddBookService addBookService) {
        this.addBookService = addBookService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        AddBookRequest request = new AddBookRequest(bookAuthor, bookTitle);
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

