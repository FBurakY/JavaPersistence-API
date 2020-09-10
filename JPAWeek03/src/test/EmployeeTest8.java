package test;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest8 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeRepository empRepository = new EmployeeRepositoryImpl(entityManager);

		Employee employee = new Employee();
		employee.setName("Fadil Burak");
		employee.setSurname("Yurtsever");
		employee.setSalary(5000);
		employee.setEmails(Arrays.asList("a@b.com", "b@c.com", "d@gmail.com"));

		
		empRepository.save(employee);
	}
}
