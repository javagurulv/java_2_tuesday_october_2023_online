package lv.javaguru.java2.lessoncode.book.app;

import java.util.HashMap;
import java.util.Map;

import lv.javaguru.java2.lessoncode.book.app.console_ui.*;
import lv.javaguru.java2.lessoncode.book.app.core.database.Database;
import lv.javaguru.java2.lessoncode.book.app.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetAllBooksService;
import lv.javaguru.java2.lessoncode.book.app.core.services.RemoveBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchBooksService;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.OrderingValidator;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.PagingValidator;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.AddBookRequestValidator;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.SearchBooksRequestFieldValidator;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.SearchBooksRequestValidator;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.RemoveBookRequestValidator;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() {
        beans.put(Database.class, new InMemoryDatabaseImpl());

        beans.put(AddBookRequestValidator.class, new AddBookRequestValidator());
        beans.put(RemoveBookRequestValidator.class, new RemoveBookRequestValidator());

        beans.put(SearchBooksRequestFieldValidator.class, new SearchBooksRequestFieldValidator());
        beans.put(OrderingValidator.class, new OrderingValidator());
        beans.put(PagingValidator.class, new PagingValidator());
        beans.put(SearchBooksRequestValidator.class, new SearchBooksRequestValidator(
                getBean(SearchBooksRequestFieldValidator.class),
                getBean(OrderingValidator.class),
                getBean(PagingValidator.class)
        ));

        beans.put(AddBookService.class, new AddBookService(
                getBean(Database.class),
                getBean(AddBookRequestValidator.class)));
        beans.put(RemoveBookService.class, new RemoveBookService(
                getBean(Database.class),
                getBean(RemoveBookRequestValidator.class)));
        beans.put(GetAllBooksService.class, new GetAllBooksService(getBean(Database.class)));
        beans.put(SearchBooksService.class, new SearchBooksService(
                getBean(Database.class),
                getBean(SearchBooksRequestValidator.class)));

        beans.put(AddBookUIAction.class, new AddBookUIAction(getBean(AddBookService.class)));
        beans.put(RemoveBookUIAction.class, new RemoveBookUIAction(getBean(RemoveBookService.class)));
        beans.put(PrintAllBooksUIAction.class, new PrintAllBooksUIAction(getBean(GetAllBooksService.class)));
        beans.put(ProgramExitUIAction.class, new ProgramExitUIAction());
        beans.put(SearchBooksUIAction.class, new SearchBooksUIAction(getBean(SearchBooksService.class)));
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
