package carsharing.DAOs;

import carsharing.domain.Car;

import java.util.List;

public interface CarDAO {
    List<Car> findAllForCompany(int companyId);
    void add(Car car);
}
