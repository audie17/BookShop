package fr.efrei.factory;

import fr.efrei.domain.*;
import java.util.Map;

public class BookShopFactory {
    public static BookShop createBookShop(Map<Book, Integer> bookInStock) {
        if (bookInStock == null) {
            return null;
        }


        return new BookShop.Builder()
                .setBookInStock(bookInStock)
                .build();
    }
}