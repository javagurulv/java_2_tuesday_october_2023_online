package classWork;

import classWork.core.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookValigatorTest {
    SearchBooksRequest request = new SearchBooksRequest("pus", "luk");
    SearchBooksRequest request2 = new SearchBooksRequest("", "");

@Test
    void test1() {
        List<CoreError> real = new SearchBookValigator().errorList(request);
        assertEquals(real.size(), 0 );
    }
    @Test
    void test2() {
        List<CoreError> real = new SearchBookValigator().errorList(request2);
       String mess = real.get(0).getField();
        assertEquals(real.size(),1);
        assertEquals(mess, "Автор и название");
    }
}