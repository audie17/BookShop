package fr.efrei.domain;
import java.util.List;
import fr.efrei.domain.Book;

public class ShoppingCart {
        private List<Book> books;

        private ShoppingCart() {
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
            private List<Book> books;

            public Builder setBooks(List<Book> books) {
                this.books = books;
                return this;
            }

            public ShoppingCart build() {
                return new ShoppingCart(this);
            }
        }

    }

