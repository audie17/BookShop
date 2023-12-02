package fr.efrei.repository;

import fr.efrei.domain.Book;
import java.util.List;

public interface IBookRepository extends IRepository<Book, String> {
    List<Book> getAll();
    void displayBookInfo(Book book);
}



