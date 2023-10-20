package lv.javaguru.java2.lessoncode.bookapp.core.requests;

public class RemoveBookRequest {

    private Long bookIdToRemove;

    public RemoveBookRequest(Long bookIdToRemove) {
        this.bookIdToRemove = bookIdToRemove;
    }

    public Long getBookIdToRemove() {
        return bookIdToRemove;
    }
}
