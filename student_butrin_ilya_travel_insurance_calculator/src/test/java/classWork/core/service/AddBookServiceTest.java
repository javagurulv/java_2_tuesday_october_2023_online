package classWork.core.service;

import classWork.Book;
import classWork.core.CoreError;
import classWork.core.database.Database;
import classWork.core.requests.AddBookRequest;
import classWork.core.response.AddBookResponse;
import classWork.core.service.valigators.AddBookValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddBookServiceTest {
    @Mock
    Database data;
    @Mock
    AddBookValidator validator;
    @InjectMocks
    AddBookService service;

    @Test
    public void Test1() {
        AddBookRequest OKrequest = new AddBookRequest("puk", "gec");
        when(validator.errorlist(OKrequest)).thenReturn(new ArrayList<>());
        AddBookResponse response = service.execute(OKrequest);
        assertEquals(response.getBook().getAuthor(), OKrequest.getAuthor());

    }

    @Test
    public void Test2() {
        AddBookRequest failRequest = new AddBookRequest(null, "gec");
        when(validator.errorlist(failRequest)).thenReturn(List.of(new CoreError("x", "y")));
        AddBookResponse response = service.execute(failRequest);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);

    }

    @Test
    public void Test3() {
        AddBookRequest failRequest = new AddBookRequest("null", "null");
        when(validator.errorlist(failRequest)).thenReturn(List.of(new CoreError("x", "y"), new CoreError("z", "d")));
        AddBookResponse response = service.execute(failRequest);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 2);
        assertEquals(response.getErrors().get(0).getField(), "x");
    }

    @Test
    public void Test4() {
        AddBookRequest Request = new AddBookRequest(null, "gec");
        when(validator.errorlist(Request)).thenReturn(new ArrayList<>());
        AddBookResponse response = service.execute(Request);
        assertNotNull(response.getBook());
        assertEquals(response.getBook().getAuthor(), "gec");
    }
    @Test
    public void Test5() {
        AddBookRequest Request = new AddBookRequest(null, "gec");
        when(validator.errorlist(Request)).thenReturn(List.of(new CoreError("we","d")));
        AddBookResponse response = service.execute(Request);
        assertNull(response.getBook());
    }
    @Test
    public void Test6() {
        AddBookRequest request = new AddBookRequest("x", "y");
        when(validator.errorlist(request)).thenReturn(List.of(new CoreError("X","x")));
        AddBookResponse response = service.execute(request);
        verifyNoInteractions(data);
    }
    @Test
    public void Test7() {
        AddBookRequest request = new AddBookRequest("x", "y");
        when(validator.errorlist(request)).thenReturn(new ArrayList<>());
        AddBookResponse response = service.execute(request);
        verify(data).addBook(new Book("x", "y"));
    }
    @Test
    public void test8() {
        AddBookRequest request = new AddBookRequest("x", "y");
        when(validator.errorlist(request)).thenReturn(new ArrayList<>());
        AddBookResponse response = service.execute(request);
        assertNotNull(data.getBooks());
        verify(data).addBook(new Book("x","y"));
        assertEquals(response.getBook().getTitle(), "x");
        assertEquals(response.getBook().getAuthor(), "y");

    }
    }