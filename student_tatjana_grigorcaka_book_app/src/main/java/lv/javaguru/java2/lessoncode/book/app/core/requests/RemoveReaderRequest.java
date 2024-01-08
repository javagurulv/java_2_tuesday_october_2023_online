package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class RemoveReaderRequest {

    private Long readerIdToRemove;

    public RemoveReaderRequest(Long readerIdToRemove) {
        this.readerIdToRemove = readerIdToRemove;
    }

    public Long getReaderIdToRemove() {
        return readerIdToRemove;
    }
}
