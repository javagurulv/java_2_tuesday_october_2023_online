package lessoncode.ui;

import lessoncode.domain.Book;
import lessoncode.services.GetAllBooksService;

public class PrintAllBooksUIAction implements UIAction {

    private GetAllBooksService getAllBooksService;

    public PrintAllBooksUIAction(GetAllBooksService getAllBooksService) {
        this.getAllBooksService = getAllBooksService;
    }

    @Override
    public void execute() {
        System.out.println("Book list: ");
        for (Book book : getAllBooksService.execute()) {
            System.out.println(book);
        }
        System.out.println("Book list end.");
    }
}
