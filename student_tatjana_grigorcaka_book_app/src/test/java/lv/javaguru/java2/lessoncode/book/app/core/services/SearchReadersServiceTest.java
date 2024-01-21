package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchReadersRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchReadersResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.SearchReadersRequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SearchReadersServiceTest {

    @Mock private JpaReaderRepository readerRepository;
    @Mock private SearchReadersRequestValidator validator;
    @InjectMocks
    private SearchReadersService service;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(service, "orderingEnabled", true);
        ReflectionTestUtils.setField(service, "pagingEnabled", true);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchReadersRequest request = new SearchReadersRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("firstName", "Must not be empty!"));
        errors.add(new CoreError("lastName", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchReadersResponse response = service.execute(request);
        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(readerRepository);
    }

    @Test
    public void shouldSearchByFirstName() {
        SearchReadersRequest request = new SearchReadersRequest("John", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("John", "Smith", "31234567891"));
        Mockito.when(readerRepository.findByFirstNameLike("John")).thenReturn(readers);

        SearchReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 1);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByLastName() {
        SearchReadersRequest request = new SearchReadersRequest(null, "Smith");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader( "John", "Smith", "31234567891"));
        Mockito.when(readerRepository.findByLastNameLike("Smith")).thenReturn(readers);

        SearchReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 1);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameAndLastName() {
        SearchReadersRequest request = new SearchReadersRequest("John", "Smith");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("John", "Smith", "31234567891"));
        Mockito.when(readerRepository.findByFirstNameAndLastNameLike("John", "Smith")).thenReturn(readers);

        SearchReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 1);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameWithOrderingAscending() {
        Ordering ordering = new Ordering("lastNAme", "ASCENDING");
        SearchReadersRequest request = new SearchReadersRequest("John", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader( "John", "Smith2", "31234567891"));
        readers.add(new Reader("John", "Smith1", "31234567891"));
        Mockito.when(readerRepository.findByFirstNameLike("John")).thenReturn(readers);

        SearchReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 2);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith1");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(1).getLastName(), "Smith2");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNAmeWithOrderingDescending() {
        Ordering ordering = new Ordering("lastName", "DESCENDING");
        SearchReadersRequest request = new SearchReadersRequest("John", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("John", "Smith1", "31234567891"));
        readers.add(new Reader( "John", "Smith2", "31234567891"));
        Mockito.when(readerRepository.findByFirstNameLike("John")).thenReturn(readers);

        SearchReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 2);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith2");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(1).getLastName(), "Smith1");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchReadersRequest request = new SearchReadersRequest("John", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("John", "Smith1", "31234567891"));
        readers.add(new Reader( "John", "Smith2", "31234567891"));
        Mockito.when(readerRepository.findByFirstNameLike("John")).thenReturn(readers);

        SearchReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 1);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith1");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchReadersRequest request = new SearchReadersRequest("John", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("John", "Smith1", "31234567891"));
        readers.add(new Reader("John", "Smith2", "31234567891"));
        Mockito.when(readerRepository.findByFirstNameLike("John")).thenReturn(readers);

        SearchReadersResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertEquals(response.getReaders().size(), 1);
        assertEquals(response.getReaders().get(0).getFirstName(), "John");
        assertEquals(response.getReaders().get(0).getLastName(), "Smith2");
        assertEquals(response.getReaders().get(0).getPersonalCode(), "31234567891");
    }

}