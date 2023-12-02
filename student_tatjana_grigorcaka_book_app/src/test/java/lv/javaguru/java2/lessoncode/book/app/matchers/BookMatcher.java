package lv.javaguru.java2.lessoncode.book.app.matchers;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.mockito.ArgumentMatcher;

import java.util.Objects;

public class BookMatcher implements ArgumentMatcher<Book> {

    private String title;
    private String author;
    private Integer issueYear;
    private Genre genre;


    public BookMatcher(String title, String author, Integer issueYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.issueYear = issueYear;
        this.genre = genre;
    }


    @Override
    public boolean matches(Book book) {
        return book.getTitle().equals(title)
                && book.getAuthor().equals(author)
                && Objects.equals(book.getIssueYear(), issueYear)
                && book.getGenre().equals(genre);

    }


}
