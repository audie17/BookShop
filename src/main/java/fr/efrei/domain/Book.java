package fr.efrei.domain;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private float price;
    private String genre;
    private int quantityAvailable;

    private Book() {}

    public Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.price = builder.price;
        this.genre = builder.genre;
        this.quantityAvailable = builder.quantityAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }

    public static class Builder {
        // Mandatory fields
        private String isbn;
        private String title;
        private String author;
        // Optional fields with default values
        private float price = 0.0f;
        private String genre = "";
        private int quantityAvailable = 0;

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setQuantityAvailable(int quantityAvailable) {
            this.quantityAvailable = quantityAvailable;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

