package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import lv.javaguru.java2.lessoncode.book.app.DatabaseCleaner;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.lessoncode.book.app.config.BookListConfiguration;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.RemoveBookService;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookListConfiguration.class})
@Sql({"/schema.sql"})
public class RemoveBookAcceptanceTest {

    @Autowired private AddBookService addBookService;
    @Autowired private RemoveBookService removeBookService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnErrorResponseWhenBookIdNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery",  1943, Genre.FABLE);
        addBookService.execute(addBookRequest1);

        RemoveBookRequest removeBookRequest2 = new RemoveBookRequest(null);
        RemoveBookResponse response = removeBookService.execute(removeBookRequest2);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookId");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveBook() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery",  1943, Genre.FABLE);
        addBookService.execute(addBookRequest1);

        RemoveBookRequest removeBookRequest2 = new RemoveBookRequest(1L);
        RemoveBookResponse response = removeBookService.execute(removeBookRequest2);

        assertTrue(response.isBookRemoved());
    }

}
