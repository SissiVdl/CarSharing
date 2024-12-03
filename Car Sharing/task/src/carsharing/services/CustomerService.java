package carsharing.services;

import carsharing.DAOImplementations.DbCustomerDAO;
import carsharing.DAOs.CustomerDAO;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
