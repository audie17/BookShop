package fr.efrei.repository;
import fr.efrei.domain.Customer;
import fr.efrei.domain.ShoppingCart;
import java.util.List;

public interface ICustomerRepository {

        Customer create(Customer customer);

        Customer read(int customerId);

        Customer update(Customer newCustomer);

        boolean delete(int cusCode);

        List<Customer> getAll();

        float calculatePoints(Customer customer, ShoppingCart shoppingCart);
}

