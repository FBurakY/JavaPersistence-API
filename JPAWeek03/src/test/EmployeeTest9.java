package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest9 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeRepository empRepository = new EmployeeRepositoryImpl(entityManager);

		Employee employee = new Employee();
		employee.setName("Fadil Burak");
		employee.setSurname("Yurtsever");
		employee.setSalary(5000);

		Map<String, String> phones = new HashMap<>();
		phones.put("HOME", "216100");
		phones.put("WORK", "216200");
		phones.put("MOBILE", "555588");
		
		employee.setPhoneNumbers(phones);

		empRepository.save(employee);
	}
}
