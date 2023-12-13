package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lv.javaguru.java2.lessoncode.book.app.DatabaseCleaner;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;

import lv.javaguru.java2.lessoncode.book.app.config.BookListConfiguration;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchBooksService;

import static org.junit.Assert.*;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookListConfiguration.class})
@Sql({"/schema.sql"})
public class AddBookAcceptanceTest {

    @Autowired private AddBookService addBookService;
    @Autowired private SearchBooksService searchBooksService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnErrorWhenBookTitleNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest(null, "Antoine de Saint-Exupery", 1943, Genre.FABLE);
        addBookService.execute(addBookRequest1);

        AddBookResponse response = addBookService.execute(addBookRequest1);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookTitle");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenBookAuthorNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", null, 1943, Genre.FABLE);
        addBookService.execute(addBookRequest1);

        AddBookResponse response = addBookService.execute(addBookRequest1);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookAuthor");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenIssueYearNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 0, Genre.FABLE);
        addBookService.execute(addBookRequest1);

        AddBookResponse response = addBookService.execute(addBookRequest1);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "issueYear");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must be greater than 0!");
    }

    @Test
    public void shouldReturnErrorWhenDuplicateBookFound() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943, Genre.FABLE);
        addBookService.execute(addBookRequest1);
        AddBookRequest addBookRequest2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943, Genre.FABLE);
        addBookService.execute(addBookRequest2);

        AddBookResponse response = addBookService.execute(addBookRequest2);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "duplicate");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Duplicate book not accepted!");
    }

    @Test
    public void shouldReturnBook() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943, Genre.FABLE);
        addBookService.execute(addBookRequest1);

        SearchBooksRequest request2 = new SearchBooksRequest("The Little Prince", null);
        SearchBooksResponse response = searchBooksService.execute(request2);

        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);

    }


}
