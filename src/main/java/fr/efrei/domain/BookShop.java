package fr.efrei.domain;
import java.util.*;

public class BookShop {
        private List<Book> bookInStock ;

        private BookShop() {
        }

        public BookShop(Builder builder) {
            this.bookInStock = builder.bookInStock;
        }

        public List<Book> getBookInStock() {
            return bookInStock;
        }

        @Override
        public String toString() {
            return "Bookshop{" +
                    "bookInStock=" + bookInStock +
                    '}';
        }
        public static class Builder {
            private List<Book> bookInStock;

            public Builder setBookInStock(List<Book> bookInStock) {
                this.bookInStock = bookInStock;
                return this;
            }
            public BookShop build() {
                return new BookShop(this);
            }
        }
    }

