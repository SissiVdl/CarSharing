package carsharing.menus;

import carsharing.DbCompanyDAO;
import carsharing.util.Keyboard;

import static java.lang.System.exit;

public final class MainMenu {

    private DbCompanyDAO companyDAO;
    private final ManagerMenu managerMenu;

    public MainMenu() {
        companyDAO = new DbCompanyDAO();
        managerMenu = new ManagerMenu(companyDAO);
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
