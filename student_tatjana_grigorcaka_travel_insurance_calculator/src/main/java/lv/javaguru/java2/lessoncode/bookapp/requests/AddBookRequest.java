package lv.javaguru.java2.lessoncode.bookapp.requests;

public class AddBookRequest {

    private String bookAuthor;
    private String bookTitle;

    public AddBookRequest(String bookAuthor,
                          String bookTitle) {
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}
