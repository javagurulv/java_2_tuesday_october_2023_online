package classWork.core.service;

import classWork.Book;
import classWork.core.database.Database;
import classWork.core.requests.GetAllBookRequest;
import classWork.core.response.GetAllBookResponce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PublicKey;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetAllBookServiceTest {
    @Mock Database data;
    @InjectMocks GetAllBookService service;

    @Test
    public void test1 () {
        GetAllBookRequest request = new GetAllBookRequest();
        when(data.getBooks()).thenReturn(List.of(
                new Book("1", "a"),
                new Book("2", "b")));
        GetAllBookResponce responce = service.execute();
        assertEquals(responce.getAllbooks().get(0).getAuthor(),"a");
        assertEquals(responce.getAllbooks().get(0).getTitle(),"1");
        assertEquals(responce.getAllbooks().get(1).getAuthor(),"b");
        assertEquals(responce.getAllbooks().get(1).getTitle(),"2");
    }

}