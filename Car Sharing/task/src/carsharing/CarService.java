package carsharing;

import carsharing.util.Keyboard;

import java.util.List;

public class CarService {
    private final DbCarDAO carDAO;

    public CarService(DbCarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void printAllForCompany(int companyId) {
        List<Car> cars = carDAO.findAllForCompany(companyId);
        if (cars.isEmpty()) {
            System.out.println("The car list is empty!");
        } else {
            cars.forEach(car -> System.out.println(car.id() + ". " + car.name()));
        }
    }

    public void createCar(Company company) {
        String name = Keyboard.getNextLine("Enter the car name:");
        carDAO.add(new Car(0,name, company.id()));
    }
}
