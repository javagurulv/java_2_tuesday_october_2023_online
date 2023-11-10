package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class AddBookRequest {

    private String bookTitle;
    private String bookAuthor;

    public AddBookRequest(String bookTitle, String bookAuthor) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}
