package fr.efrei.views;
<<<<<<< HEAD

=======
>>>>>>> origin/master
import fr.efrei.domain.*;
import java.util.Scanner;

public class ShoppingCartMenu {
    public void runShoppingCart() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\u001B[33m"+"「 ✦ Shopping Cart Menu: ✦ 」\n"+"\u001B[0m");
            System.out.println("1. Add Book to Cart\n");
            System.out.println("2. Remove Book from Cart\n");
            System.out.println("3. See Cart\n");
            System.out.println("4. See the Total price\n");
            System.out.println("0. Exit\n");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    ShoppingCart.addBooktoCart();
                    break;

                case 2:
                    ShoppingCart.remBooktoCart();
                    break;

                case 3:
                    ShoppingCart.displayCartInfo();
                    break;

                case 4:
                    ShoppingCart.calculateTotalPrice();
                    break;

                case 0:
                    System.out.println("Exiting Shopping Cart. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
<<<<<<< HEAD


}

=======
    public class Bookshop {

        // ... Other methods and properties

        // Function to add a book to the shopping cart
        public void addBookToCart(ShoppingCart shoppingCart, Book book) {
            shoppingCart.addBook(book);
            System.out.println("Book added to the shopping cart successfully.");
        }

        // Function to remove a book from the shopping cart
        public void removeBookFromCart(ShoppingCart shoppingCart, Book book) {
            boolean removed = shoppingCart.removeBook(book);
            if (removed) {
                System.out.println("Book removed from the shopping cart successfully.");
            } else {
                System.out.println("Book not found in the shopping cart.");
            }
        }

        // Function to display information about the books in the shopping cart
        public void seeCartInfo(ShoppingCart shoppingCart) {
            System.out.println("Shopping Cart Information:");
            shoppingCart.displayCartInfo();
        }

        // Function to calculate the total price of the books in the shopping cart
        public float calculateTotalPrice(ShoppingCart shoppingCart) {
            float totalPrice = shoppingCart.calculateTotalPrice();
            System.out.println("Total Price of Books in the Shopping Cart: $" + totalPrice);
            return totalPrice;
        }
    }

}
>>>>>>> origin/master
