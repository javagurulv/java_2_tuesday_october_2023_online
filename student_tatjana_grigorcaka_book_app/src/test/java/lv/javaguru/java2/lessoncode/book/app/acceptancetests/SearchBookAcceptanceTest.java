package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import static org.junit.Assert.assertEquals;

import lv.javaguru.java2.lessoncode.book.app.DatabaseCleaner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lv.javaguru.java2.lessoncode.book.app.config.SpringCoreConfiguration;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchBooksService;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
public class SearchBookAcceptanceTest {

    @Autowired private AddBookService addBookService;
    @Autowired private SearchBooksService searchBooksService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }
    @Test
    public void searchBooks() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1", 1943);
        addBookService.execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2", 1943);
        addBookService.execute(request2);

        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null);
        SearchBooksResponse response = searchBooksService.execute(request3);

        assertEquals(response.getBooks().size(), 2);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));
        assertEquals(response.getBooks().get(1).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));

    }

    @Test
    public void searchBooksOrderingDescending() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1", 1943);
        addBookService.execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2", 1943);
        addBookService.execute(request2);

        Ordering ordering = new Ordering("author", "DESCENDING");
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering);
        SearchBooksResponse response = searchBooksService.execute(request3);

        assertEquals(response.getBooks().size(), 2);

        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));
        assertEquals(response.getBooks().get(1).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));

    }

    @Test
    public void searchBooksOrderingAscending() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1", 1943);
        addBookService.execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2", 1943);
        addBookService.execute(request2);

        Ordering ordering = new Ordering("author", "ASCENDING");
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering);
        SearchBooksResponse response = searchBooksService.execute(request3);

        assertEquals(response.getBooks().size(), 2);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));
        assertEquals(response.getBooks().get(1).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(1).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));



    }

    @Test
    public void searchBooksOrderingPagingFirstPage() {
        AddBookRequest request1 = new AddBookRequest( "The Little Prince", "Antoine de Saint-Exupery1", 1943);
        addBookService.execute(request1);

        AddBookRequest request2 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery2", 1943);
        addBookService.execute(request2);

        Ordering ordering = new Ordering("author", "ASCENDING");
        Paging paging = new Paging(1, 1);
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering, paging);
        SearchBooksResponse response = searchBooksService.execute(request3);

        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery1");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));

    }

    @Test
    public void searchBooksOrderingPagingSecondPage() {
        AddBookRequest request1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery1", 1943);
        addBookService.execute(request1);

        AddBookRequest request2 = new AddBookRequest( "The Little Prince", "Antoine de Saint-Exupery2", 1943);
        addBookService.execute(request2);

        Ordering ordering = new Ordering("author", "ASCENDING");
        Paging paging = new Paging(2, 1);
        SearchBooksRequest request3 = new SearchBooksRequest("The Little Prince", null, ordering, paging);
        SearchBooksResponse response = searchBooksService.execute(request3);

        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery2");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));


}


}
