package lv.javaguru.java2.lessoncode.book.app.core.responses;

import java.util.List;

public class RemoveReaderResponse extends CoreResponse {

    private boolean readerRemoved;

    public RemoveReaderResponse(List<CoreError> errors) {
        super(errors);
    }

    public RemoveReaderResponse(boolean readerRemoved) {

        this.readerRemoved = readerRemoved;
    }

    public boolean isReaderRemoved() {
        return readerRemoved;
    }
}
