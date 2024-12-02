package carsharing;

import carsharing.DAOImplementations.DbCarDAO;
import carsharing.DAOImplementations.DbCompanyDAO;
import carsharing.DAOImplementations.DbCustomerDAO;
import carsharing.DAOs.CarDAO;
import carsharing.DAOs.CompanyDAO;
import carsharing.DAOs.CustomerDAO;
import carsharing.menus.MainMenu;
import carsharing.services.CarService;
import carsharing.services.CompanyService;
import carsharing.services.CustomerService;

public class Main {

    public static void main(String[] args) {

        CompanyDAO companyDAO = new DbCompanyDAO();
        CarDAO carDAO = new DbCarDAO();
        CustomerDAO customerDAO = new DbCustomerDAO();

        CompanyService companyService = new CompanyService(companyDAO);
        CarService carService = new CarService(carDAO);
        CustomerService customerService = new CustomerService(customerDAO);

        MainMenu mainMenu = new MainMenu(companyService, carService, customerService);
        mainMenu.show();
    }
}
