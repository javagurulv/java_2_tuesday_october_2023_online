package classWork;

import classWork.consoleUI.*;
import classWork.core.database.Database;
import classWork.core.database.InMemoryDatabaseImpl;
import classWork.core.service.AddBookService;
import classWork.core.service.GetAllBookService;
import classWork.core.service.RemoveBookService;
import classWork.core.service.SearchBooksService;
import classWork.core.service.valigators.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();
    public ApplicationContext() {
        beans.put(Database.class, new InMemoryDatabaseImpl());
        beans.put(AddBookValidator.class, new AddBookValidator(getBean(Database.class)));
        beans.put(RemoveBookValidators.class, new RemoveBookValidators());
        beans.put(AddBookService.class, new AddBookService(getBean(Database.class),getBean(AddBookValidator.class)));
        beans.put(RemoveBookService.class, new RemoveBookService(getBean(Database.class), getBean(RemoveBookValidators.class)));
        beans.put(GetAllBookService.class, new GetAllBookService(getBean(Database.class)));
        beans.put(AddBookUIAction.class, new AddBookUIAction(getBean(AddBookService.class)));
        beans.put(RemoveBookUIAction.class, new RemoveBookUIAction(getBean(RemoveBookService.class)));
        beans.put(GetAllBooksUIAction.class, new GetAllBooksUIAction(getBean(GetAllBookService.class)));
        beans.put(ExitUIAction.class, new ExitUIAction());
        beans.put(SearchBooksFieldValidator.class, new SearchBooksFieldValidator());
        beans.put(SearchBookOrderingValigator.class, new SearchBookOrderingValigator());
        beans.put(SearchBookPagingValigator.class, new SearchBookPagingValigator());
        beans.put(SearchBookValigator.class, new SearchBookValigator(
                getBean(SearchBooksFieldValidator.class),
                getBean(SearchBookOrderingValigator.class),
                getBean(SearchBookPagingValigator.class)));
        beans.put(SearchBooksService.class, new SearchBooksService(
                getBean(SearchBookValigator.class),
                getBean(Database.class)));
        beans.put(SearchBookUIAction.class, new SearchBookUIAction(getBean(SearchBooksService.class)));
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
