package carsharing.DAOs;

import carsharing.domain.Company;

import java.util.List;

public interface CompanyDAO {
    List<Company> findAll();
    void add(Company company);
    Company findById(int id);
}
