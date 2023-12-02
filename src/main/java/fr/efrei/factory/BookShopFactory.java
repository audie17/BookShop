package fr.efrei.factory;

import fr.efrei.domain.*;
import java.util.List;

public class BookShopFactory {
    public static BookShop createBookShop(List<Book> bookInStock) {
        if (bookInStock == null) {
            return null;
        }


        return new BookShop.Builder()
                .setBookInStock(bookInStock)
                .build();
    }
}