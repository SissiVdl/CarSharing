package carsharing;

import carsharing.DAOImplementations.DbCarDAO;
import carsharing.DAOImplementations.DbCompanyDAO;
import carsharing.menus.MainMenu;
import carsharing.services.CarService;
import carsharing.services.CompanyService;

public class Main {

    public static void main(String[] args) {

        DbCompanyDAO companyDAO = new DbCompanyDAO();
        DbCarDAO carDAO = new DbCarDAO();

        CompanyService companyService = new CompanyService(companyDAO);
        CarService carService = new CarService(carDAO);

        MainMenu mainMenu = new MainMenu(companyService, carService);
        mainMenu.show();
    }
}