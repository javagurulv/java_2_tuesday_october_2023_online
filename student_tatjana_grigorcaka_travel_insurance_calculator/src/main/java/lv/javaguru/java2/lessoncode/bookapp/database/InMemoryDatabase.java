package lv.javaguru.java2.lessoncode.bookapp.database;

import lv.javaguru.java2.lessoncode.bookapp.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Book> findBookByTitleAndAuthor(String author, String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .filter(book -> book.getAuthor().equals(author))
                .findFirst();
    }
}
