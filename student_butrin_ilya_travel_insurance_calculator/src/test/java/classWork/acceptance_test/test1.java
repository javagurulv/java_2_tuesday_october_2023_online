 package classWork.acceptance_test;

import classWork.BookListConfiguration;
import classWork.core.requests.AddBookRequest;
import classWork.core.response.GetAllBookResponce;
import classWork.core.service.AddBookService;
import classWork.core.service.GetAllBookService;
import classWork.vihicleDatabase.DatabaseCleaner;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
public class test1 {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(BookListConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void shouldReturnCorrectBookList() {
        AddBookRequest request1 = new AddBookRequest("x", "y");
        getAddBookService().execute(request1);
        AddBookRequest request2 = new AddBookRequest("x2", "y2");
        getAddBookService().execute(request2);
        GetAllBookResponce responce = getAllBooksService().execute();
        assertEquals(responce.getAllbooks().size(), 2);
    }

    private AddBookService getAddBookService() {
        return appContext.getBean(AddBookService.class);
    }

    private GetAllBookService getAllBooksService() {
        return appContext.getBean(GetAllBookService.class);
    }

    private DatabaseCleaner getDatabaseCleaner() {
        return appContext.getBean(DatabaseCleaner.class);
    }
}