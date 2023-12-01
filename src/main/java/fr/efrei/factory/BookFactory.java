package fr.efrei.factory;

import fr.efrei.domain.Book;
import fr.efrei.util.Helper;

public class BookFactory {

    public static Book createBook(String isbn, String title, String author, float price, String genre, int quantityAvailable) {
        if (Helper.isNullorEmpty(isbn) || Helper.isNullorEmpty(title) || Helper.isNullorEmpty(author))
            return null;

        if (price <= 0)
            return null;

        return new Book.Builder()
                .setIsbn(isbn)
                .setTitle(title)
                .setAuthor(author)
                .setPrice(price)
                .setGenre(genre)
                .setQuantityAvailable(quantityAvailable)
                .build();
    }

}


