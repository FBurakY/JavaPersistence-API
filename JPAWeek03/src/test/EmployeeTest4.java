package test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;
import entity.Phone;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest4 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeRepository empRepository = new EmployeeRepositoryImpl(entityManager);

		Employee employee = new Employee();
		employee.setName("Fadil Burak");
		employee.setSurname("Yurtsever");
		employee.setSalary(15000);

		Phone phone1 = new Phone("553052", "MOBILE");
		Phone phone2 = new Phone("312200", "HOME");
		Phone phone3 = new Phone("312500", "WORK");

		empRepository.insertPhone(phone1);
		empRepository.insertPhone(phone2);
		empRepository.insertPhone(phone3);

		employee.getPhones().add(phone1);
		employee.getPhones().add(phone2);
		employee.getPhones().add(phone3);

		empRepository.save(employee);

	}
}
