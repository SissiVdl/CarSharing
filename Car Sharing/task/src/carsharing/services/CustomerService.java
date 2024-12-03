package carsharing.services;

import carsharing.DAOImplementations.DbCustomerDAO;
import carsharing.DAOs.CustomerDAO;
import carsharing.domain.Customer;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void createCustomer() {
        System.out.println("Enter the customer name:");
        String name = carsharing.util.Keyboard.getNextLine();
        Customer customer = new Customer(null, name, null);
        customerDAO.add(customer);
        System.out.println("The customer was created!");
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomerById(int choice) {
        return customerDAO.findById(choice);
    }
}
