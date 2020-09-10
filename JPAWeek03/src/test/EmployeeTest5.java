package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;
import entity.Project;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeTest5 {

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
		
		Employee employee3 = new Employee();
		employee3.setName("Mathilda");
		employee3.setSurname("C");
		employee3.setSalary(15000);
		
		empRepository.save(employee);
		empRepository.save(employee2);
		empRepository.save(employee3);
		
		
		Project project = new Project("Start Up V1");
		Project project2 = new Project("Start Up V2");
		Project project3 = new Project("Start Up V3");
		
		empRepository.insertProject(project);
		empRepository.insertProject(project2);
		empRepository.insertProject(project3);
		
		
		entityManager.getTransaction().begin();
		employee.getProjects().add(project);
		employee.getProjects().add(project3);
		
		employee2.getProjects().add(project2);
		
		employee3.getProjects().add(project);
		employee3.getProjects().add(project2);
		employee3.getProjects().add(project3);
		
		entityManager.getTransaction().commit();
	}
}
