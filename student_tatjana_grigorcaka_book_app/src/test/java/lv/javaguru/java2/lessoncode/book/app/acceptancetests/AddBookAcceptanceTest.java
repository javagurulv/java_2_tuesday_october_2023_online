package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIApplicationContextBuilder;
import org.junit.Test;

import lv.javaguru.java2.lessoncode.book.app.dependency_injection.ApplicationContext;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchBooksService;

import static org.junit.Assert.*;

public class AddBookAcceptanceTest {

    private ApplicationContext appContext =
            new DIApplicationContextBuilder().build("lv.javaguru.java2.lessoncode.book.app");

    @Test
    public void shouldReturnErrorWhenBookTitleNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest(null, "Antoine de Saint-Exupery", Genre.FABLE);
        getAddBookService().execute(addBookRequest1);

        AddBookResponse response = getAddBookService().execute(addBookRequest1);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookTitle");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenBookAuthorNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", null, Genre.FABLE);
        getAddBookService().execute(addBookRequest1);

        AddBookResponse response = getAddBookService().execute(addBookRequest1);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "bookAuthor");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenGenreNotProvided() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", null);
        getAddBookService().execute(addBookRequest1);

        AddBookResponse response = getAddBookService().execute(addBookRequest1);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "genre");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenDuplicateBookFound() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", Genre.FABLE);
        getAddBookService().execute(addBookRequest1);
        AddBookRequest addBookRequest2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", Genre.FABLE);
        getAddBookService().execute(addBookRequest2);

        AddBookResponse response = getAddBookService().execute(addBookRequest2);

        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "duplicate");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Duplicate book not accepted!");
    }

    @Test
    public void shouldReturnBook() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", Genre.FABLE);
        getAddBookService().execute(addBookRequest1);

        SearchBooksRequest request2 = new SearchBooksRequest("The Little Prince", null);
        SearchBooksResponse response = getSearchBooksService().execute(request2);

        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);
    }

    private AddBookService getAddBookService() { return appContext.getBean(AddBookService.class); }

    private SearchBooksService getSearchBooksService() { return appContext.getBean(SearchBooksService.class); }

}
