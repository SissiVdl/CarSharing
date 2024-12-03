package carsharing.DAOs;

import carsharing.domain.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();
    void add(Customer customer);
    Customer findById(int id);
}
