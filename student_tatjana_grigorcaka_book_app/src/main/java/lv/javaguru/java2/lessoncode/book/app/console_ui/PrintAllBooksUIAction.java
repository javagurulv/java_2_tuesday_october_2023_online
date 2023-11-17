package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetAllBooksService;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIDependency;

@DIComponent
public class PrintAllBooksUIAction implements UIAction {

    @DIDependency private GetAllBooksService getAllBooksService;

    @Override
    public void execute() {
        System.out.println("Book list: ");
        GetAllBooksRequest request = new GetAllBooksRequest();
        GetAllBooksResponse response = getAllBooksService.execute(request);
        response.getBooks().forEach(System.out::println);
        System.out.println("Book list end.");
    }
}
