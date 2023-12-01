package fr.efrei.domain;
import java.util.*;
import fr.efrei.domain.Book;

public class Bookshop {
        private Map<Book, Integer> bookInStock;

        private Bookshop() {
        }

        public Bookshop(Builder builder) {
            this.bookInStock = builder.bookInStock;
        }

        public Map<Book, Integer> getBookInStock() {
            return bookInStock;
        }

        @Override
        public String toString() {
            return "Bookshop{" +
                    "bookInStock=" + bookInStock +
                    '}';
        }
        public static class Builder {
            private Map<Book, Integer> bookInStock;

            public Builder setBookInStock(Map<Book, Integer> bookInStock) {
                this.bookInStock = bookInStock;
                return this;
            }
            public Bookshop build() {
                return new Bookshop(this);
            }
        }
    }

