package fr.efrei.repository;

import java.util.ArrayList;
import java.util.List;
import fr.efrei.domain.Book;

public class BookRepository implements IBookRepository {
    private static BookRepository repository = null;
    private List<Book> bookDB = null;

    // Private constructor to enforce the singleton pattern
    private BookRepository() {
        bookDB = new ArrayList<>();
    }

    public static BookRepository getRepository() {
        if (repository == null) {
            repository = new BookRepository();
        }
        return repository;
    }

    @Override
    public Book create(Book book) {
        boolean success = bookDB.add(book);
        return success ? book : null;
    }

    @Override
    public Book read(String bookCode) {
        Book book = bookDB.stream()
                .filter(s -> s.getIsbn().equals(bookCode))
                .findAny()
                .orElse(null);
        return book;
    }

    @Override
    public Book update(Book newBook) {
        Book oldBook = read(newBook.getIsbn());
        if (oldBook == null)
            return null;

        boolean success = delete(newBook.getIsbn());
        if (success) {
            boolean successAdded = bookDB.add(newBook);
            return successAdded ? newBook : null;
        }

        return null;
    }

    @Override
    public boolean delete(String bookCode) {
        Book bookToDelete = read(bookCode);
        return bookDB.remove(bookToDelete);
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(bookDB);
    }
}

