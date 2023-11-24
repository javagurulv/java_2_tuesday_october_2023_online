package lv.javaguru.java2.lessoncode.book.app.matchers;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Genre;
import org.mockito.ArgumentMatcher;

import java.util.Objects;

public class BookMatcher implements ArgumentMatcher<Book> {

    private String title;
    private String author;
    private Genre genre;

    public BookMatcher(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }


    @Override
    public boolean matches(Book book) {
        return book.getTitle().equals(title)
                && book.getAuthor().equals(author)
                && book.getGenre().equals(genre);
    }


}
