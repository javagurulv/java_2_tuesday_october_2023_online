package lv.javaguru.java2.lessoncode.book.app.core.requests;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;

public class AddBookRequest {

    private String bookTitle;
    private String bookAuthor;
    private Integer issueYear;
    private Genre genre;

    public AddBookRequest(String bookTitle, String bookAuthor, Integer issueYear, Genre genre) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.issueYear = issueYear;
        this.genre = genre;

    }

    public String getBookTitle() {
        return bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public Integer getIssueYear() { return issueYear; }
    public Genre getGenre() { return genre; }
}


