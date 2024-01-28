package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class RemoveReaderRequest {

    private Long readerId;

    public RemoveReaderRequest(Long readerId) {
        this.readerId = readerId;
    }

    public Long getReaderId() {
        return readerId;
    }
}
