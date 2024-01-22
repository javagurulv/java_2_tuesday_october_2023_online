package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllReadersRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllReadersResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class GetAllReadersServiceTest {

    @Mock
    private JpaReaderRepository readerRepository;
    @InjectMocks
    private GetAllReadersService service;

    @Test
    public void shouldGetReadersFromDb() {
        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("John", "Smith", "312345-67891"));
        Mockito.when(readerRepository.findAll()).thenReturn(readers);

        GetAllReadersRequest request = new GetAllReadersRequest();
        GetAllReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 1);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "312345-67891");
    }

}
