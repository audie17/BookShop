package fr.efrei.repository;

import fr.efrei.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static CustomerRepository repository = null;
    private List<Customer> cusDB = null;

    private CustomerRepository() {
        cusDB = new ArrayList<>();
    }

    public static CustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }

    @Override
    public Customer searchCustomerbyName(String customerName) {
        if (cusDB == null) {
            throw new IllegalStateException("Customer database is not initialized.");
        }

        // Assuming your Customer class has a getName() method
        return cusDB.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(customerName))
                .findAny()
                .orElse(null);
    }

    @Override
    public float calculateTotalPoint(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Invalid customer. Cannot calculate total points.");
        }

        return customer.getPointNumber();
    }

    @Override
    public Customer create(Customer customer) {
        boolean success = cusDB.add(customer);
        return success ? customer : null;
    }

    @Override
    public Customer read(int customerId) {
        if (cusDB == null) {
            throw new IllegalStateException("Customer database is not initialized.");
        }

        return cusDB.stream()
                .filter(c -> c.getCus_id() == customerId)
                .findAny()
                .orElse(null);
    }

    @Override
    public Customer update(Customer newCustomer) {
        if (cusDB == null) {
            throw new IllegalStateException("Customer database is not initialized.");
        }

        Customer oldCustomer = read(newCustomer.getCus_id());
        if (oldCustomer == null)
            return null;

        boolean success = delete(newCustomer.getCus_id());
        if (success) {
            boolean successAdded = cusDB.add(newCustomer);
            return successAdded ? newCustomer : null;
        }

        return null;
    }

    @Override
    public boolean delete(int cusCode) {
        if (cusDB == null) {
            throw new IllegalStateException("Customer database is not initialized.");
        }

        Customer customerToDelete = read(cusCode);
        return cusDB.remove(customerToDelete);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(cusDB);
    }
}
