package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.requests.ReturnBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.ReturnBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.ReturnBookRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class ReturnBookService {

    @Autowired private ReturnBookRequestValidator validator;
    @Autowired private JpaBookRepository bookRepository;

    @Autowired private JpaReaderRepository readerRepository;

    @Autowired private JpaReaderBookRepository readerBookRepository;


    public ReturnBookResponse execute(ReturnBookRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ReturnBookResponse(errors);
        }

        return readerBookRepository.findById(request.getId())
                .map(readerBook -> {
                    readerBook.setBookReturnDate(new Date());

                    return new ReturnBookResponse(List.of());
                })
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new ReturnBookResponse(errors);
                });
    }


}
