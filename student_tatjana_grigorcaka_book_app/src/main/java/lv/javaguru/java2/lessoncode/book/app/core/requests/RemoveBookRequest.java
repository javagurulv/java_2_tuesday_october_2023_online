package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class RemoveBookRequest {

    private Long bookIdToRemove;

    public RemoveBookRequest(Long bookIdToRemove) {
        this.bookIdToRemove = bookIdToRemove;
    }

    public Long getBookIdToRemove() {
        return bookIdToRemove;
    }
}
