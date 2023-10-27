package lv.javaguru.java2.lessoncode.bookapp.core.database;

import lv.javaguru.java2.lessoncode.bookapp.core.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryDatabase implements Database {

    private Long nextId = 1L;
    private List<Book> books = new ArrayList<>();

    @Override
    public void save(Book book) {
        book.setId(nextId);
        nextId++;
        books.add(book);
    }

    @Override
        public boolean deleteById(Long id) {
            boolean isBookDeleted = false;
            Optional<Book> bookToDeleteOpt = books.stream()
                    .filter(book -> book.getId().equals(id))
                    .findFirst();
            if (bookToDeleteOpt.isPresent()) {
                Book bookToRemove = bookToDeleteOpt.get();
                isBookDeleted = books.remove(bookToRemove);
            }
            return isBookDeleted;
        }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitleAndAuthor(String title, String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findBookByTitleAndAuthor(String author, String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .filter(book -> book.getAuthor().equals(author))
                .findFirst();
    }
}
