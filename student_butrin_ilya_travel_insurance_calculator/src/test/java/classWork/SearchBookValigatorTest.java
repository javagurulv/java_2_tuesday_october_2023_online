/*package classWork;

import classWork.core.CoreError;
import classWork.core.requests.AddBookRequest;
import classWork.core.requests.Ordering;
import classWork.core.requests.Paging;
import classWork.core.requests.SearchBooksRequest;
import classWork.core.service.valigators.SearchBookOrderingValigator;
import classWork.core.service.valigators.SearchBookPagingValigator;
import classWork.core.service.valigators.SearchBookValigator;
import classWork.core.service.valigators.SearchBooksFieldValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
public class SearchBookValigatorTest {

    Ordering or1 = new Ordering("","");
    Ordering or2 = new Ordering("keks","");
    Ordering or3 = new Ordering("","keks");
    Ordering or4 = new Ordering("по названию","по возрастанию");
    Ordering or5 = new Ordering("по названию","кекс");
    Ordering or6 = new Ordering("кекс","кекс");
    Paging pa1 = new Paging(null, null);
    Paging pa2 = new Paging(5, null);
    Paging pa3 = new Paging(null, 5);
    Paging pa4 = new Paging(1, 3);
    Paging pa5 = new Paging(1, -3);
    Paging pa6 = new Paging(-2, -5);
    Paging pa7 = new Paging(-2, 1);

    SearchBooksRequest searchrequest = new SearchBooksRequest("pus", "luk",pa1, or1);
    SearchBooksRequest searchrequest2 = new SearchBooksRequest("", "", pa2,  or1);
    SearchBooksRequest searchrequest3 = new SearchBooksRequest("pus", "kap",pa3, or2);
    SearchBooksRequest searchrequest4 = new SearchBooksRequest("ler", "kap",pa4, or3);
    SearchBooksRequest searchrequest5 = new SearchBooksRequest("ler", "ser",pa5, or4);
    SearchBooksRequest searchrequest6 = new SearchBooksRequest("tol", "kap",pa6, or5);
    SearchBooksRequest searchrequest7 = new SearchBooksRequest("", "", pa7, or6);

  SearchBookValigator validator = new SearchBookValigator();
    @Test
   public void test1() {

        List<CoreError> real = validator.errorList(searchrequest);
        assertEquals(real.size(), 0);
    }

    @Test
    public void test2() {
        List<CoreError> real = validator.errorList(searchrequest2);
        String mess = real.get(0).getField();
        assertEquals(real.size(), 2);
        assertEquals(mess, "Автор и название");
    }

    @Test
    public void test3() {
        List<CoreError> real = validator.errorList(searchrequest3);
        String mess = real.get(0).getField();
        String mess2 = real.get(1).getField();
        assertEquals(real.size(), 3);
        assertEquals(mess, "сортировка(критерий)");
        assertEquals(mess2, "сортировка");

    }

    @Test
    public void test4() {
        List<CoreError> real = validator.errorList(searchrequest4);
        String mess = real.get(0).getField();
        String mess2 = real.get(1).getField();
        assertEquals(real.size(), 2);
        assertEquals(mess, "сортировка(возр/убыв)");
        assertEquals(mess2, "сортировка");
    }

    @Test
    public void test5() {
        List<CoreError> real = validator.errorList(searchrequest5);
        assertEquals(real.size(), 1);
    }

    @Test
    public void test6() {
        List<CoreError> real = validator.errorList(searchrequest6);
        String mess = real.get(0).getField();
        assertEquals(real.size(), 3);
        assertEquals(mess, "сортировка(возр/убыв)");

    }

   @Test
   public void test7() {
       List<CoreError> real = validator.errorList(searchrequest7);
        assertEquals(real.size(), 4);
    }
}

 */