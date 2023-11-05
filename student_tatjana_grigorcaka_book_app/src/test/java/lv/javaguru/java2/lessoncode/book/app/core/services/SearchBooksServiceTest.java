package lv.javaguru.java2.lessoncode.book.app.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.database.Database;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.SearchBooksRequestValidator;

@RunWith(MockitoJUnitRunner.class)
public class SearchBooksServiceTest  {

    @Mock
    private Database database;
    @Mock private SearchBooksRequestValidator validator;
    @InjectMocks
    private SearchBooksService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchBooksRequest request = new SearchBooksRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("title", "Must not be empty!"));
        errors.add(new CoreError("author", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchBooksResponse response = service.execute(request);
        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldSearchByTitle() {
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery"));
        Mockito.when(database.findByTitle("The Little Prince")).thenReturn(books);

        SearchBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery");
    }

    @Test
    public void shouldSearchByAuthor() {
        SearchBooksRequest request = new SearchBooksRequest(null, "Antoine de Saint-Exupery");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery"));
        Mockito.when(database.findByAuthor("Antoine de Saint-Exupery")).thenReturn(books);

        SearchBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery");
    }

    @Test
    public void shouldSearchByTitleAndAuthor() {
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", "Antoine de Saint-Exupery");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery"));
        Mockito.when(database.findByTitleAndAuthor("The Little Prince", "Antoine de Saint-Exupery")).thenReturn(books);

        SearchBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery");
    }

    @Test
    public void shouldSearchByTitleWithOrderingAscending() {
        Ordering ordering = new Ordering("author", "ASCENDING");
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery2"));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery1"));
        Mockito.when(database.findByTitle("The Little Prince")).thenReturn(books);

        SearchBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 2);
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery2");
    }

    @Test
    public void shouldSearchByTitleWithOrderingDescending() {
        Ordering ordering = new Ordering("author", "DESCENDING");
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery1"));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery2"));
        Mockito.when(database.findByTitle("The Little Prince")).thenReturn(books);

        SearchBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 2);
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery1");
    }

    @Test
    public void shouldSearchByTitleWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery1"));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery2"));
        Mockito.when(database.findByTitle("The Little Prince")).thenReturn(books);

        SearchBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
    }

    @Test
    public void shouldSearchByTitleWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchBooksRequest request = new SearchBooksRequest("The Little Prince", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery1"));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery2"));
        Mockito.when(database.findByTitle("The Little Prince")).thenReturn(books);

        SearchBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery2");
    }

}