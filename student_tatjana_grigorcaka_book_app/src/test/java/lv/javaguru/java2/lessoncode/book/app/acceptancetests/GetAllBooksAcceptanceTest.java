package lv.javaguru.java2.lessoncode.book.app.acceptancetests;

import static org.junit.Assert.assertEquals;

import lv.javaguru.java2.lessoncode.book.app.DatabaseCleaner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import lv.javaguru.java2.lessoncode.book.app.config.BookListConfiguration;

import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetAllBooksService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookListConfiguration.class})
@Sql({"/schema.sql"})
public class GetAllBooksAcceptanceTest {

    @Autowired private AddBookService addBookService;
    @Autowired private GetAllBooksService getAllBooksService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnCorrectBookList() {
        AddBookRequest addBookRequest1 = new AddBookRequest("The Little Prince", "Antoine de Saint-Exupery", 1943);
        addBookService.execute(addBookRequest1);

        AddBookRequest addBookRequest2 = new AddBookRequest("The Alchemist","Paulo Coelho", 1988);
        addBookService.execute(addBookRequest2);

        GetAllBooksRequest getAllBooksRequest3 = new GetAllBooksRequest();
        GetAllBooksResponse response = getAllBooksService.execute(getAllBooksRequest3);

        assertEquals(response.getBooks().size(), 2);
    }


}

