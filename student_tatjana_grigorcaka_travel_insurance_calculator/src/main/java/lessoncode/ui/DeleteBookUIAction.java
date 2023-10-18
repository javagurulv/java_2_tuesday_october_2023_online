package lessoncode.ui;

import lessoncode.services.DeleteBookService;

import java.util.Scanner;

public class DeleteBookUIAction implements UIAction {

    private DeleteBookService deleteBookService;

    public DeleteBookUIAction(DeleteBookService deleteBookService) {
        this.deleteBookService = deleteBookService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();


        deleteBookService.execute(bookTitle, bookAuthor);

        System.out.println("Your book was deleted from the list: ");


    }
}
