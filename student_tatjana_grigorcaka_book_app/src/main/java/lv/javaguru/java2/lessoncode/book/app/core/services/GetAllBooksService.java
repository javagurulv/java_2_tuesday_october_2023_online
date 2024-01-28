package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllBooksService {
    @Autowired private JpaBookRepository bookRepository;

    public GetAllBooksResponse execute(GetAllBooksRequest request) {
        List<Book> books = bookRepository.findAll();
        return new GetAllBooksResponse(books);
    }
}
