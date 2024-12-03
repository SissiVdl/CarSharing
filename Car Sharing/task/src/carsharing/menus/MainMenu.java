package carsharing.menus;

import carsharing.DbCarDAO;
import carsharing.DbCompanyDAO;
import carsharing.CarService;
import carsharing.CompanyService;
import carsharing.util.Keyboard;

import static java.lang.System.exit;

public final class MainMenu {

    private final CompanyService companyService;
    private final CarService carService;
    private final ManagerMenu managerMenu;

    public MainMenu() {
        DbCompanyDAO companyDAO = new DbCompanyDAO();
        DbCarDAO carDAO = new DbCarDAO();
        companyService = new CompanyService(companyDAO);
        carService = new CarService(carDAO);
        managerMenu = new ManagerMenu(companyService, carService);
    }

    public void show() {
        System.out.println("1. Log in as a manager");
        System.out.println("0. Exit");

        handleChoice();
    }

    public void handleChoice() {
        int choice = Keyboard.getInt();
        switch (choice) {
            case 1 -> managerMenu.show();
            case 0 -> stopProgram();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    public void stopProgram() {
        exit(0);
    }
}