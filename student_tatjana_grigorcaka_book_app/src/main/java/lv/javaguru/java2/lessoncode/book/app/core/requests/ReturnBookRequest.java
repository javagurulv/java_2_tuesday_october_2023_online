package lv.javaguru.java2.lessoncode.book.app.core.requests;

import java.util.Date;

public class ReturnBookRequest {

    private Long id;

    private Date bookReturnDate;


    public ReturnBookRequest() { }

    public ReturnBookRequest(Long id, Date bookReturnDate) {
        this.id = id;
        this.bookReturnDate = bookReturnDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(Date bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }
}
