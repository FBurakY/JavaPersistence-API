package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Address;
import entity.Company;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest7 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeRepository empRepository = new EmployeeRepositoryImpl(entityManager);

		Company company = new Company("Apache Foundation");

		Address address = new Address("stree1", "road1", "no1", "istanbul", "34000");

		company.setAddress(address);
		empRepository.insertCompany(company);

	}
}
