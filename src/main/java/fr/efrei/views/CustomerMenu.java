package fr.efrei.views;

import fr.efrei.domain.Customer;
import fr.efrei.repository.CustomerRepository;

import java.util.Scanner;

public class CustomerMenu {
    private CustomerRepository customerRepository;

    public CustomerMenu() {
        this.customerRepository = customerRepository;
    }

    public void runCustomer() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\u001B[35m" + "「 ✦ Customer Menu: ✦ 」\n" + "\u001B[0m");
            System.out.println("1. Add a Customer");
            System.out.println("2. Remove a Customer");
            System.out.println("3. Search a Customer by Name");
            System.out.println("4. See Fidelity Points");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;

                case 2:
                    remCustomer();
                    break;

                case 3:
                    searchCustomer();
                    break;

                case 4:
                    seeFidelityPoints();
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

    private void addCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer details:");

        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Surname: ");
        String surname = scanner.nextLine();


        Customer newCustomer = new Customer.Builder()
                .setCus_id(customerId)
                .setName(name)
                .setSurname(surname)
                .setPointNumber(100) //faire une fonction calculer point
                .build();


        customerRepository.create(newCustomer);

        System.out.println("Customer added successfully.");
    }

    private void remCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID to remove: ");
        int customerId = scanner.nextInt();


        boolean removed = customerRepository.delete(customerId);

        if (removed) {
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer not found in the repository.");
        }
    }

    private void searchCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name to search: ");
        String customerName = scanner.nextLine();


        Customer foundCustomer = customerRepository.searchCustomerbyName(customerName);

        if (foundCustomer != null) {
            System.out.println("Customer found:");
            displayCustomerInfo(foundCustomer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void seeFidelityPoints() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID to see points: ");
        int customerId = scanner.nextInt();

        Customer customer = customerRepository.read(customerId);

        if (customer != null) {

            float points = customerRepository.calculateTotalPoint(customer);
            System.out.println("Total Fidelity Points: " + points);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void displayCustomerInfo(Customer customer) {
        System.out.println("Customer ID: " + customer.getCus_id());
        System.out.println("Name: " + customer.getName());

    }
}
