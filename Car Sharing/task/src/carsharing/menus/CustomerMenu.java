package carsharing.menus;

import carsharing.domain.Customer;
import carsharing.services.CustomerService;

import java.util.List;

public class CustomerMenu {

    private final CustomerService customerService;
    private final MainMenu mainMenu;
    private final CompanyMenu companyMenu;

    public CustomerMenu(CustomerService customerService, MainMenu mainMenu, CompanyMenu companyMenu) {
        this.customerService = customerService;
        this.mainMenu = mainMenu;
        this.companyMenu = companyMenu;
    }

    public void show() {
        List< Customer > customers = displayCustomers();
        if (customers.isEmpty()) {
            return;
        }
        handleChoice();
    }

    private List<Customer> displayCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("The customer list is empty!");
        } else {
            System.out.println("Choose a customer:");
            customers.forEach(cust -> System.out.println(cust.id() + ". " + cust.name()));
            System.out.println("0. Back");
        }
        return customers;
    }

    private void handleChoice() {
        int choice = carsharing.util.Keyboard.getInt();
        if (choice == 0) {
            mainMenu.show();
        } else {
            Customer customer = customerService.getCustomerById(choice);
            if (customer != null) {
                showCustomerOptions();
            } else {
                System.out.println("There is no customer with this ID!");
            }
        }
    }

    public void showCustomerOptions() {
        System.out.println("1. Rent a car");
        System.out.println("2. My rented car");
        System.out.println("3. Return a rented car");
        System.out.println("0. Back");

        int choice = carsharing.util.Keyboard.getInt();
    }
}
