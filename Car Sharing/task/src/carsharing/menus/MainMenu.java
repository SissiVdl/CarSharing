package carsharing.menus;

import carsharing.services.CarService;
import carsharing.services.CompanyService;
import carsharing.services.CustomerService;
import carsharing.util.Keyboard;

import static java.lang.System.exit;

public final class MainMenu {

    private final CompanyService companyService;
    private final CarService carService;
    private final CustomerService customerService;
    private final ManagerMenu managerMenu;
    private final CustomerMenu customerMenu;
    private final CompanyMenu companyMenu;

    public MainMenu(CompanyService companyService, CarService carService, CustomerService customerService) {
        this.companyService = companyService;
        this.carService = carService;
        this.customerService = customerService;
        this.companyMenu = new CompanyMenu(carService, companyService);
        this.managerMenu = new ManagerMenu(companyService, carService, this);
        this.customerMenu = new CustomerMenu(customerService,this, companyMenu);
    }

    public void show() {
        System.out.println("1. Log in as a manager");
        System.out.println("2. Log in as a customer");
        System.out.println("3. Create a customer");
        System.out.println("0. Exit");

        handleChoice();
    }

    public void handleChoice() {
        int choice = Keyboard.getInt();
        switch (choice) {
            case 1 -> managerMenu.show();
            case 2 -> customerMenu.show();
            case 3 -> customerService.createCustomer();
            case 0 -> stopProgram();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    public void stopProgram() {
        exit(0);
    }
}