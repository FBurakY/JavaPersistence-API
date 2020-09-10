package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;
import entity.ParkingSpace;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeRepository empRepository = new EmployeeRepositoryImpl(entityManager);

		Employee employee = new Employee();
		employee.setName("Fadil Burak");
		employee.setSurname("Yurtsever");
		employee.setSalary(5000);

		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setFlat(-1);
		parkingSpace.setLocation("A-10");

		parkingSpace.setEmployee(employee);
		empRepository.insertParkingSpace(parkingSpace);

		employee.setParkingSpace(parkingSpace);
		empRepository.save(employee);
		
		ParkingSpace foundPs = entityManager.find(ParkingSpace.class, 1);
		
		System.out.println(foundPs);
		
	}
}
