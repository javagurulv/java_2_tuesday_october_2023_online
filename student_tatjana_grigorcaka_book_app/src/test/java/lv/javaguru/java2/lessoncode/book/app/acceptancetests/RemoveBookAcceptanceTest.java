package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.lessoncode.book.app.config.BookListConfiguration;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.RemoveBookService;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;

import static org.junit.Assert.*;

public class RemoveBookAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }

    @Test
    public void shouldReturnErrorResponseWhenBookIdNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery",  Genre.FABLE);
        getAddBookService().execute(addBookRequest1);

        RemoveBookRequest removeBookRequest2 = new RemoveBookRequest(null);
        RemoveBookResponse response = getRemoveBookService().execute(removeBookRequest2);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookId");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveBook() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery",  Genre.FABLE);
        getAddBookService().execute(addBookRequest1);

        RemoveBookRequest removeBookRequest2 = new RemoveBookRequest(1L);
        RemoveBookResponse response = getRemoveBookService().execute(removeBookRequest2);

        assertTrue(response.isBookRemoved());
    }

    private AddBookService getAddBookService() {
        return appContext.getBean(AddBookService.class);
    }

    private RemoveBookService getRemoveBookService() {
        return appContext.getBean(RemoveBookService.class);
    }

}
