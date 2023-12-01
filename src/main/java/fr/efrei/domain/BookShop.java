package fr.efrei.domain;
import java.util.*;

public class BookShop {
        private Map<Book, Integer> bookInStock;

        private BookShop() {
        }

        public BookShop(Builder builder) {
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
            public BookShop build() {
                return new BookShop(this);
            }
        }
    }

