package fr.efrei.factory;

import fr.efrei.domain.*;
import java.util.List;


public class ShoppingCartFactory {
    public static ShoppingCart createShoppingCart( List<Book> books) {
        if (books == null) {
            return null;}

            return new ShoppingCart.Builder()
                    .setBooks(books)
                    .build();

        }
}
