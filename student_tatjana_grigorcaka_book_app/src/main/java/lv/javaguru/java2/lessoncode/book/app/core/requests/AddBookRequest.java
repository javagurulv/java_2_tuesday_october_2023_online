package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class AddBookRequest {

    private String title;
    private String author;
    private Integer issueYear;


    public AddBookRequest(String title, String author, Integer issueYear) {
        this.title = title;
        this.author = author;
        this.issueYear = issueYear;


    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Integer getIssueYear() { return issueYear; }

}


