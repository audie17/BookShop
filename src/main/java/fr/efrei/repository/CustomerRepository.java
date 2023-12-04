package fr.efrei.repository;
import fr.efrei.domain.*;
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

    @Override
    public float calculatePoints(Customer customer, ShoppingCart shoppingCart) {
        float POINTS_PER_DOLLAR = 1;
        if (customer == null || shoppingCart == null) {
            throw new IllegalArgumentException("Invalid customer or shopping cart.");
        }

        List<Book> booksInCart = shoppingCart.getBooks();
        float totalPrice = booksInCart.stream()
                .map(Book::getPrice)
                .reduce(0.0f, Float::sum);

        float pointsEarned = totalPrice * POINTS_PER_DOLLAR;
        Customer updatedCustomer = new Customer.Builder()
                .setCus_id(customer.getCus_id())
                .setName(customer.getName())
                .setSurname(customer.getSurname())
                .setPointNumber(customer.getPointNumber() + pointsEarned)
                .build();


        update(updatedCustomer);

        return pointsEarned;
    }


}

