package fr.efrei;
import java.util.Scanner;
import fr.efrei.views.*;
import fr.efrei.domain.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\u001B[34m"+"「 ✦ Main Menu:\n"+"\u001B[0m");
            System.out.println("1. Book\n");
            System.out.println("2. Shopping Cart\n");
            System.out.println("3. Customers\n");
            System.out.println("0. Exit\n");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    BookMenu bookMenu = new BookMenu();
                    bookMenu.runBook();
                    break;

                case 2:
                    ShoppingCartMenu shoppingCartMenu = new ShoppingCartMenu();
                    shoppingCartMenu.runShoppingCart();
                    break;


                case 3:
                    CustomerMenu customerMenu = new CustomerMenu();
                    customerMenu.runCustomer();
                    break;

                case 0:
                    System.out.println("Exiting Main Menu. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}