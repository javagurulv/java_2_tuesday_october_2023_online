package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.ReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.RemoveReaderRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class RemoveReaderService {

    @Autowired private ReaderRepository readerRepository;
    @Autowired private RemoveReaderRequestValidator validator;


    public RemoveReaderResponse execute(RemoveReaderRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveReaderResponse(errors);
        }
        boolean isReaderRemoved = readerRepository.deleteById(request.getReaderIdToRemove());
        return new RemoveReaderResponse(isReaderRemoved);
    }

}

