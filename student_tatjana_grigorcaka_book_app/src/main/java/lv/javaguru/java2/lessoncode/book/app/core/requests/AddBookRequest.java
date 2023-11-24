package lv.javaguru.java2.lessoncode.book.app.core.requests;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;

public class AddBookRequest {

    private String bookTitle;
    private String bookAuthor;
    private Genre genre;

    public AddBookRequest(String bookTitle, String bookAuthor, Genre genre) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.genre = genre;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public Genre getGenre() { return genre; }

}


