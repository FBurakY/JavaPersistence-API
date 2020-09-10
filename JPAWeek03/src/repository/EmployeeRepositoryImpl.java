package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Company;
import entity.Department;
import entity.Employee;
import entity.ParkingSpace;
import entity.Phone;
import entity.Project;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private EntityManager entityManager;

	public EmployeeRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void save(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();

	}

	@Override
	public void insertDepartment(Department department) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(department);
		transaction.commit();

	}

	@Override
	public void insertParkingSpace(ParkingSpace parkingSpace) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(parkingSpace);
		transaction.commit();
	}

	@Override
	public void insertPhone(Phone phone) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(phone);
		transaction.commit();
	}

	@Override
	public void insertProject(Project project) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(project);
		transaction.commit();

	}

	@Override
	public void insertCompany(Company company) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(company);
		transaction.commit();

	}

}
