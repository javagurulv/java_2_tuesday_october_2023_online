package lv.javaguru.java2.lessoncode.book.app.core.responses;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;

import java.util.List;

public class GetAllReadersResponse extends CoreResponse {

    private List<Reader> readers;

    public GetAllReadersResponse(List<Reader> readers) {
        this.readers = readers;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}
