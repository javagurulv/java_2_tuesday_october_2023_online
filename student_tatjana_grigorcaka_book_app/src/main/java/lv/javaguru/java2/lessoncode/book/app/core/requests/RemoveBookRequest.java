package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class RemoveBookRequest {

    private Long bookId;

    public RemoveBookRequest(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }
}
