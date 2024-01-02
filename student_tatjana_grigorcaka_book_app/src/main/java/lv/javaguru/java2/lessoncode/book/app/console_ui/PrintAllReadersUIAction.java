package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllReadersRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllReadersResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetAllBooksService;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetAllReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAllReadersUIAction implements UIAction {

    @Autowired private GetAllReadersService getAllReadersService;

    @Override
    public void execute() {
        System.out.println("Reader list: ");
        GetAllReadersRequest request = new GetAllReadersRequest();
        GetAllReadersResponse response = getAllReadersService.execute(request);
        response.getReaders().forEach(System.out::println);
        System.out.println("Reader list end.");
    }
}
