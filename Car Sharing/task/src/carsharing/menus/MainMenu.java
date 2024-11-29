package carsharing.menus;

import carsharing.DbCarDAO;
import carsharing.DbCompanyDAO;
import carsharing.util.Keyboard;

import static java.lang.System.exit;

public final class MainMenu {

    private final DbCompanyDAO companyDAO;
    private final DbCarDAO carDAO;
    private final ManagerMenu managerMenu;

    public MainMenu() {
        companyDAO = new DbCompanyDAO();
        carDAO = new DbCarDAO();
        managerMenu = new ManagerMenu(companyDAO, carDAO);
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
