package repository;

import entity.Company;
import entity.Department;
import entity.Employee;
import entity.ParkingSpace;
import entity.Phone;
import entity.Project;

public interface EmployeeRepository {

	public void save(Employee employee);

	public void insertDepartment(Department department);

	public void insertParkingSpace(ParkingSpace parkingSpace);

	public void insertPhone(Phone phone);

	public void insertProject(Project project);
	
	public void insertCompany(Company company);
}
