package fr.efrei.views;
import fr.efrei.domain.*;
import fr.efrei.repository.BookRepository;

import java.util.List;
import java.util.Scanner;

public class BookMenu {
    private BookRepository bookRepository;


    public BookMenu() {
        this.bookRepository = bookRepository;
    }
    public void runBook() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\u001B[34m" + "「 ✦ Book Menu: ✦ 」\n" + "\u001B[0m");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search a Book by ISBN");
            System.out.println("4. Search a Book by name");
            System.out.println("See Book information ");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    remBook();
                    break;

                case 3:
                    Scanner scanISBN = new Scanner(System.in);
                    System.out.println("Enter ISBN of the book you are looking for:");
                    String searchIsbn = scanISBN.nextLine();
                    Book foundBook_isbn = searchBookbyISBN(searchIsbn);
                    if (foundBook_isbn != null) {
                        System.out.println("Book found:");
                        seeBookInfo(foundBook_isbn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    Scanner scanName = new Scanner(System.in);
                    System.out.println("Enter ISBN of the book you are looking for:");
                    String searchName = scanName.nextLine();
                    Book foundBook_name = searchBookbyISBN(searchName);
                    if (foundBook_name != null) {
                        System.out.println("Book found:");
                        seeBookInfo(foundBook_name);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    Scanner scanBook = new Scanner(System.in);
                    System.out.println("Enter a Book Name");
                    String bookName = scanBook.nextLine();
                    seeBookInfo(searchBookbyName(bookName));
                    break;

                case 0:
                    System.out.println("Exiting Customer. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }


        private void addBook() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Book details:");

            System.out.print("Book ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Book title: ");
            String title = scanner.nextLine();

            System.out.print("Book Author: ");
            String author = scanner.nextLine();

            System.out.print("Book Price: ");
            float price = scanner.nextFloat();

            System.out.print("Book genre: ");
            String genre = scanner.nextLine();

            System.out.print("Book in Stock available: ");
            int quantityAvailable = scanner.nextInt();



            Book newBook = new Book.Builder()
                    .setIsbn(isbn)
                    .setTitle(title)
                    .setAuthor(author)
                    .setPrice(price)
                    .setGenre(genre)
                    .setQuantityAvailable(quantityAvailable)
                    .build();


            bookRepository.create(newBook);

            System.out.println("Customer added successfully.");
        }

        public void remBook() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter book to remove: ");
            String bookISBN= scanner.nextLine();


            boolean removed = bookRepository.delete(bookISBN);

            if (removed) {
                System.out.println("Book removed from inventory successfully.");
            } else {
                System.out.println("Book not found in inventory.");
            }
        }

        public Book searchBookbyISBN(String bookISBN) {
            List<Book> bookList = bookRepository.getAll();
            for (Book book : bookList) {
                if (book.getIsbn().equals(bookISBN)) {
                    return book;
                }
            }
            return null;
        }


        public Book searchBookbyName(String bookName) {
            List<Book> bookList = bookRepository.getAll();
            for (Book book : bookList) {
                if (book.getIsbn().equals(bookName)) {
                    return book;
                }
            }
            return null;
        }

        public void seeBookInfo(Book book) {

            if (bookRepository == null) {
                System.out.println("No books available in the inventory.");
            } else {
                System.out.println("Book Inventory Information:\n");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Quantity: " + book.getQuantityAvailable());
                System.out.println("Price: $" + book.getPrice());
                System.out.println("Genre: " + book.getGenre());
                System.out.println("-------------");

            }
        }
    }

