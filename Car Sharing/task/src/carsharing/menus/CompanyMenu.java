package carsharing.menus;

import carsharing.CarService;
import carsharing.Company;
import carsharing.util.Keyboard;
import java.sql.SQLOutput;

/* TODO
    [ ] Car list - print the list of cars that belong to the chosen company.
        Method (printAllForCompany) in car service that prints the cars ordered by their ID column. indexes start from 1.
            If the car list is empty, print the message The car list is empty!
        Based on methods in DbCarDAO (findAll), CarDAO (findAll) and DBClient (selectForCarList).
        After printing the car list, print the company menu again.
    [ ] If the option Create a car was chosen, the program should prompt the user for the car name and save it in the database.
        Method (createCar) in car service that creates a car with the given name and the ID of the chosen company.
        Based on methods in DbCarDAO (add), carDAO (add) and DBClient (run).
*/
public class CompanyMenu {

    private final CarService carService;

    public CompanyMenu(CarService carService) {
        this.carService = carService;
    }

    public void show(Company company) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1. Car list");
            System.out.println("2. Create a car");
            System.out.println("0. Back");

            int choice = Keyboard.getInt();
            switch (choice) {
                case 1 -> carService.printAllForCompany(company.id());
                case 2 -> carService.createCar(company);
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
