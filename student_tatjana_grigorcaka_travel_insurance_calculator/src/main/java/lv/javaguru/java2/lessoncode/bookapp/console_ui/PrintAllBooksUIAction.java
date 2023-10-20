package lv.javaguru.java2.lessoncode.bookapp.console_ui;

import lv.javaguru.java2.lessoncode.bookapp.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.bookapp.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.bookapp.core.services.GetAllBooksService;

public class PrintAllBooksUIAction implements UIAction {

    private GetAllBooksService getAllBooksService;

    public PrintAllBooksUIAction(GetAllBooksService getAllBooksService) {
        this.getAllBooksService = getAllBooksService;
    }

    @Override
    public void execute() {
        System.out.println("Book list: ");
        GetAllBooksRequest request = new GetAllBooksRequest();
        GetAllBooksResponse response = getAllBooksService.execute(request);
        response.getBooks().forEach(System.out::println);
        System.out.println("Book list end.");
    }
}
