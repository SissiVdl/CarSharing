package carsharing;

import java.util.List;

public interface CarDAO {
    List<Car> findAllForCompany(int companyId);
    void add(Car car);
}
