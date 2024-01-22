package lv.javaguru.java2.lessoncode.book.app.core.requests;

import java.util.Date;

public class TakeBookRequest {

    private Long id;
    private Long readerId;
    private Long bookId;

    private Date bookOutDate;

    private Date bookReturnDate;

    public TakeBookRequest() { }

    public TakeBookRequest(Long id, Long readerId, Long bookId, Date bookOutDate, Date bookReturnDate) {
        this.id = id;
        this.readerId = readerId;
        this.bookId = bookId;
        this.bookOutDate = bookOutDate;
        this.bookReturnDate = bookReturnDate;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getBookOutDate(Long id) {
        return bookOutDate;
    }

    public void setBookOutDate(Date bookOutDate) {
        this.bookOutDate = bookOutDate;
    }

    public Date getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(Date bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
