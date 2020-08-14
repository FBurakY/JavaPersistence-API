package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Employee;

public class EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void saveEmployee(Employee employee) {
		// programatic transaction
		// veritabanina insert islemi, update islemi bir transaction arasinda olmasi
		// gerekli.

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
	}

	public Employee findEmployeeById(int id) {
		// read isleminde transactiona gerek yoktur
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> findAllEmployees() {
		// transactiona gerek yok!
		// JPQL grameri
		//
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return query.getResultList();
	}

	public void removeEmployee(int id) {
		// delete/remove islemi transaction arasinda olmali!

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(findEmployeeById(id));
		transaction.commit();
	}

	public Employee raiseSalary(int id, int raise) {
		// JPA da bir transaciton arasinda Entity guncellersek bu durum veritabanina yansir.
		// begin-commit
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee foundEmployee = findEmployeeById(id);
		if (foundEmployee != null) {
			foundEmployee.setSalary(foundEmployee.getSalary() + raise);
		}
		transaction.commit();
		return foundEmployee;
	}
}
