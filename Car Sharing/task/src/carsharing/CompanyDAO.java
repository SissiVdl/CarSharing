package carsharing;

import java.util.List;

public interface CompanyDAO {
    List<Company> findAll();
    void add(Company company);
    Company findById(int id);
}
