package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllReadersRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllReadersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllReadersService {
    @Autowired private JpaReaderRepository readerRepository;

    public GetAllReadersResponse execute(GetAllReadersRequest request) {
        List<Reader> readers = readerRepository.findAll();
        return new GetAllReadersResponse(readers);
    }
}
