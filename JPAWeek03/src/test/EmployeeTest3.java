package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Department;
import entity.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();

		EmployeeRepository empRepository = new EmployeeRepositoryImpl(entityManager);

		Employee employee = new Employee();
		employee.setName("Fadil Burak");
		employee.setSurname("Yurtsever");
		employee.setSalary(5000);

		Employee employee2 = new Employee();
		employee2.setName("Mehtap");
		employee2.setSurname("C");
		employee2.setSalary(5000);

		empRepository.save(employee);
		empRepository.save(employee2);

		Department department = new Department();
		department.setDeptName("IT - Dept");
		empRepository.insertDepartment(department);

		
		entityManager.getTransaction().begin();
		employee.setDepartment(department);
		employee2.setDepartment(department);
		
		department.getEmployees().add(employee);
		department.getEmployees().add(employee2);
		entityManager.getTransaction().commit();
		
		//
		Department departmentFound = entityManager.find(Department.class, 3);
		departmentFound.getEmployees().forEach(System.out::println);

	}
}
