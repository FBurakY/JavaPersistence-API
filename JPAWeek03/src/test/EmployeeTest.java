package test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Department;
import entity.Employee;
import entity.EmployeeType;
import entity.ParkingSpace;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeRepository empRepository = new EmployeeRepositoryImpl(entityManager);

		Employee employee = new Employee();
		employee.setName("Fadil Burak");
		employee.setSurname("Yurtsever");
		employee.setSalary(15000);

		EmployeeType empType = EmployeeType.PART_TIME;
		employee.setEmployeeType(empType);

		Date today = new Date();

		employee.setStartDate(today);

		byte[] imageData = "content".getBytes();

		employee.setImage(imageData);

		Department department = new Department();
		department.setDeptName("IT - Dept");

		empRepository.insertDepartment(department);
		
		
		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setFlat(-1);
		parkingSpace.setLocation("A-10");
		
		
		ParkingSpace parkingSpace2 = new ParkingSpace();
		parkingSpace2.setFlat(-2);
		parkingSpace2.setLocation("B-20");
		
		empRepository.insertParkingSpace(parkingSpace);
		empRepository.insertParkingSpace(parkingSpace2);

		employee.setDepartment(department);
		employee.setParkingSpace(parkingSpace);
		empRepository.save(employee);

		Employee employee2 = new Employee();
		employee2.setName("Mehtap");
		employee2.setSurname("C");
		employee2.setSalary(5000);
		employee2.setEmployeeType(EmployeeType.PART_TIME);

		employee2.setDepartment(department);
		
		
		
		//employee2.setParkingSpace(parkingSpace);
		employee2.setParkingSpace(parkingSpace2);
		empRepository.save(employee2);
		
		
		
		
		entityManager.close();
		emf.close();
	}
}
