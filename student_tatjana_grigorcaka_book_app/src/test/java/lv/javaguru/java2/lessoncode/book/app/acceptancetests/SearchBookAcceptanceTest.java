package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import static org.junit.Assert.assertEquals;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.lessoncode.book.app.config.BookListConfiguration;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchBooksService;

public class SearchBookAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }
    @Test
    public void searchBooks() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1", Genre.FABLE);
        getAddBookService().execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2",  Genre.FABLE);
        getAddBookService().execute(request2);

        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null);
        SearchBooksResponse response = getSearchBooksService().execute(request3);

        assertEquals(response.getBooks().size(), 2);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);
        assertEquals(response.getBooks().get(1).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);
    }

    @Test
    public void searchBooksOrderingDescending() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1",  Genre.FABLE);
        getAddBookService().execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2", Genre.FABLE);
        getAddBookService().execute(request2);

        Ordering ordering = new Ordering("author", "DESCENDING");
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering);
        SearchBooksResponse response = getSearchBooksService().execute(request3);

        assertEquals(response.getBooks().size(), 2);

        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);
        assertEquals(response.getBooks().get(1).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);
    }

    @Test
    public void searchBooksOrderingAscending() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1", Genre.FABLE);
        getAddBookService().execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2", Genre.FABLE);
        getAddBookService().execute(request2);

        Ordering ordering = new Ordering("author", "ASCENDING");
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering);
        SearchBooksResponse response = getSearchBooksService().execute(request3);

        assertEquals(response.getBooks().size(), 2);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);
        assertEquals(response.getBooks().get(1).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);

    }

    @Test
    public void searchBooksOrderingPagingFirstPage() {
        AddBookRequest request1 = new AddBookRequest( "The Little Prince", "Antoine de Saint-Exupery1", Genre.FABLE);
        getAddBookService().execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2", Genre.FABLE);
        getAddBookService().execute(request2);

        Ordering ordering = new Ordering("author", "ASCENDING");
        Paging paging = new Paging(1, 1);
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering, paging);
        SearchBooksResponse response = getSearchBooksService().execute(request3);

        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);
    }

    @Test
    public void searchBooksOrderingPagingSecondPage() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1", Genre.FABLE);
        getAddBookService().execute(request1);

        AddBookRequest request2 = new AddBookRequest( "The Little Prince", "Antoine de Saint-Exupery2", Genre.FABLE);
        getAddBookService().execute(request2);

        Ordering ordering = new Ordering("author", "ASCENDING");
        Paging paging = new Paging(2, 1);
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering, paging);
        SearchBooksResponse response = getSearchBooksService().execute(request3);

        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getGenre(), Genre.FABLE);

}

    private AddBookService getAddBookService() {
        return appContext.getBean(AddBookService.class);
    }

    private SearchBooksService getSearchBooksService() {
        return appContext.getBean(SearchBooksService.class);
    }

}
