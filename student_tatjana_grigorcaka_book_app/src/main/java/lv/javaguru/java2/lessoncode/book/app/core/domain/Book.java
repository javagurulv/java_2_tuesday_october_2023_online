package lv.javaguru.java2.lessoncode.book.app.core.domain;

import java.util.Objects;

public class Book {

    private Long id;
    private String title;
    private String author;
    private Integer issueYear;
    private Genre genre;

    public Book() {
    }

    public Book(String title, String author, Integer issueYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.issueYear = issueYear;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIssueYear() { return issueYear; }

    public void setIssueYear(Integer issueYear) { this.issueYear = issueYear; }

    public Genre getGenre() { return genre; }

    public void setGenre(Genre genre) { this.genre = genre; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getIssueYear(), book.getIssueYear()) && getGenre() == book.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthor(), getIssueYear(), getGenre());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", issueYear=" + issueYear +
                ", genre=" + genre +
                '}';
    }
}
