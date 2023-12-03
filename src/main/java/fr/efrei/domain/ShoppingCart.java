package fr.efrei.domain;
import java.util.List;
import fr.efrei.domain.Book;

public class ShoppingCart {
    private int shoppingCart_id;
    private List<Book> books;
    private ShoppingCart() {
    }

    public int getShoppingCart_id() {
        return shoppingCart_id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public ShoppingCart(Builder builder) {
            this.books = builder.books;
        }


        @Override
        public String toString() {
            return "ShoppingCart{" +
                    "books=" + books +
                    '}';
        }


        public static class Builder {
            private int shoppingCart_id;
            private List<Book> books;

            public void setShoppingCart_id(int shoppingCart_id) {
                this.shoppingCart_id = shoppingCart_id;
            }

            public Builder setBooks(List<Book> books) {
                this.books = books;
                return this;
            }

            public ShoppingCart build() {
                return new ShoppingCart(this);
            }
        }

    }

