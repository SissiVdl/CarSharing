package carsharing.services;

import carsharing.DAOImplementations.DbCarDAO;
import carsharing.DAOs.CarDAO;
import carsharing.domain.Car;
import carsharing.domain.Company;
import carsharing.util.Keyboard;

import java.util.List;

public class CarService {
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void printAllForCompany(int companyId) {
        List<Car> cars = carDAO.findAllForCompany(companyId);
        if (cars.isEmpty()) {
            System.out.println("The car list is empty!");
        } else {
            final int[] counter = {1};
            cars.forEach(car -> {
                System.out.println(counter[0] + ". " + car.name());
                counter[0]++;
            });
        }
    }

    public void createCar(Company company) {
        String name = Keyboard.getNextLine("Enter the car name:");
        carDAO.add(new Car(null,name, company.id()));
        System.out.println("The car was added!");
    }
}
