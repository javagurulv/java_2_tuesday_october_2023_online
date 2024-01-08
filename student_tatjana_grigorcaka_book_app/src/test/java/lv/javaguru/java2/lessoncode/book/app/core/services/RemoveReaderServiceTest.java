package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.BookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.ReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.RemoveBookRequestValidator;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.RemoveReaderRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class RemoveReaderServiceTest {
    @Mock
    private ReaderRepository readerRepository;
    @Mock private RemoveReaderRequestValidator validator;
    @InjectMocks
    private RemoveReaderService service;

    @Test
    public void shouldReturnErrorWhenReaderIdNotProvided() {
        RemoveReaderRequest request = new RemoveReaderRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("readerId", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveReaderResponse response = service.execute(request);
        assertTrue(response.containsErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getErrorCode(), "readerId");
        assertEquals(response.getErrors().get(0).getErrorMessage(), "Must not be empty!");
    }

    @Test
    public void shouldDeleteReaderWithIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(readerRepository.deleteById(1L)).thenReturn(true);
        RemoveReaderRequest request = new RemoveReaderRequest(1L);
        RemoveReaderResponse response = service.execute(request);
        assertFalse(response.containsErrors());
        assertTrue(response.isReaderRemoved());
    }

}