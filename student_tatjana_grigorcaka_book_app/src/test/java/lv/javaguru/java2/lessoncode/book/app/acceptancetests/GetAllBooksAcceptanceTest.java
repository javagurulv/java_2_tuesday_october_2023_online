package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import static org.junit.Assert.assertEquals;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.lessoncode.book.app.config.BookListConfiguration;

import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetAllBooksService;

public class GetAllBooksAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }

    @Test
    public void shouldReturnCorrectBookList() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943, Genre.FABLE);
        getAddBookService().execute(addBookRequest1);

        AddBookRequest addBookRequest2 = new AddBookRequest("The Alchemist","Paulo Coelho", 1988, Genre.ADVENTURE);
        getAddBookService().execute(addBookRequest2);

        GetAllBooksRequest getAllBooksRequest3 = new GetAllBooksRequest();
        GetAllBooksResponse response = getAllBooksService().execute(getAllBooksRequest3);

        assertEquals(response.getBooks().size(), 2);
    }

    private AddBookService getAddBookService() {
        return appContext.getBean(AddBookService.class);
    }

    private GetAllBooksService getAllBooksService() {
        return appContext.getBean(GetAllBooksService.class);
    }

}

