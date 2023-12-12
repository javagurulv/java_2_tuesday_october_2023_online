/* package classWork.acceptance_test;

import classWork.BookListConfiguration;
import classWork.core.CoreError;
import classWork.core.requests.AddBookRequest;
import classWork.core.requests.RemoveBookReques;
import classWork.core.response.AddBookResponse;
import classWork.core.response.RemoveBookResponce;
import classWork.core.service.AddBookService;
import classWork.core.service.GetAllBookService;
import classWork.core.service.RemoveBookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test2 {
    private ApplicationContext applicationContext;
    @Before
    public void setup () {
        applicationContext = new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }
    @Test
    public void testDeleteBook () {
        getAddBookService().execute(new AddBookRequest("1","a"));
        getAddBookService().execute(new AddBookRequest("2","b"));
        assertEquals(getAllBookService().execute().getAllbooks().size(),2);
        RemoveBookReques delrequest = new RemoveBookReques(1l);
        getRemoveBookService().execute(delrequest);
        assertEquals(getAllBookService().execute().getAllbooks().size(),1);

    }


    public AddBookService getAddBookService () {
        return  applicationContext.getBean(AddBookService.class);
    }
    public RemoveBookService getRemoveBookService () {
        return  applicationContext.getBean(RemoveBookService.class);
    }
    public GetAllBookService getAllBookService () {
        return  applicationContext.getBean(GetAllBookService.class);
    }
}
*/