package lessoncode.ui;

import lessoncode.AddBookRequest;
import lessoncode.AddBookResponse;
import lessoncode.BusinessError;
import lessoncode.services.AddBookService;

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
            for (BusinessError error : response.getErrors()) {
                System.out.println("Error: " + error.getErrorCode() + " " + error.getErrorMessage());
            }
        } else {
            System.out.println("Your book was added to the list: ");
        }
    }
}

