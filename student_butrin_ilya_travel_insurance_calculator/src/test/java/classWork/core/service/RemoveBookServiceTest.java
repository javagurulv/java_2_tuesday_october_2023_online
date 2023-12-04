package classWork.core.service;

import classWork.core.CoreError;
import classWork.core.database.Database;
import classWork.core.requests.RemoveBookReques;
import classWork.core.response.RemoveBookResponce;
import classWork.core.service.valigators.RemoveBookValidators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class RemoveBookServiceTest {
    @Mock Database data;
    @Mock RemoveBookValidators validators;
    @InjectMocks RemoveBookService service;

    @Test
    public  void test1 () {
        RemoveBookReques reques = new RemoveBookReques(1);
        when(validators.errorList(reques)).thenReturn(List.of(new CoreError("field", "message")));
        RemoveBookResponce responce = service.execute(reques);
        assertTrue(responce.hasErrors());
    }
    @Test
    public  void test2 () {
        RemoveBookReques reques = new RemoveBookReques(1);
        when(validators.errorList(reques)).thenReturn(List.of(new CoreError("field", "message")));
        RemoveBookResponce responce = service.execute(reques);
        verifyNoInteractions(data);
    }
    @Test
    public  void test3 () {
        RemoveBookReques reques = new RemoveBookReques(1L);
        when(validators.errorList(reques)).thenReturn(new ArrayList<>());
        RemoveBookResponce responce = service.execute(reques);
        verify(data).deleteBook(1L);
    }
    @Test
    public  void test4 () {
        RemoveBookReques reques = new RemoveBookReques(1L);
        when(validators.errorList(reques)).thenReturn(new ArrayList<>());
        when(data.deleteBook(1l)).thenReturn(true);
        RemoveBookResponce responce = service.execute(reques);
        assertTrue(responce.getBookDeleted());
    }
}