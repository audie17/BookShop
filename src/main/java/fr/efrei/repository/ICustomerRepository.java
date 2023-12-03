package fr.efrei.repository;

import fr.efrei.domain.Customer;

import java.util.List;

public interface ICustomerRepository {
    Customer searchCustomerbyName(String customerName);

    float calculateTotalPoint(Customer customer);

    Customer create(Customer customer);

    Customer read(int customerId);

    Customer update(Customer newCustomer);

    boolean delete(int cusCode);

    List<Customer> getAll();
}
