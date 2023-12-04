package fr.efrei.views;

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


}

