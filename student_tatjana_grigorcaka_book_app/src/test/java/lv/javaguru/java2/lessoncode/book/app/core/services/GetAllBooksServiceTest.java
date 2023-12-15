package lv.javaguru.java2.lessoncode.book.app.core.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.lessoncode.book.app.core.database.BookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetAllBooksServiceTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private GetAllBooksService service;

    @Test
    public void shouldGetBooksFromDb() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery", 1943));
        Mockito.when(bookRepository.getAllBooks()).thenReturn(books);

        GetAllBooksRequest request = new GetAllBooksRequest();
        GetAllBooksResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getBooks().size(), 1);
        assertEquals(response.getBooks().get(0).getTitle(), "The Little Prince");
        assertEquals(response.getBooks().get(0).getAuthor(), "Antoine de Saint-Exupery");
        assertEquals(response.getBooks().get(0).getIssueYear(), Integer.valueOf(1943));
    }

}
