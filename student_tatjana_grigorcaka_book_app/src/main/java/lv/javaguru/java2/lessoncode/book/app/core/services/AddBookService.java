package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.AddBookRequestValidator;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Component
@Transactional
public class AddBookService {
    @Autowired private JpaBookRepository bookRepository;
    @Autowired private AddBookRequestValidator validator;


    public AddBookResponse execute(AddBookRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddBookResponse(errors);
        }

        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getIssueYear());

        bookRepository.save(book);

        return new AddBookResponse(book);
    }

}
