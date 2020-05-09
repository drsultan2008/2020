package luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import luv2code.springboot.thymeleafdemo.entity.Employee;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// Sort MAGIC
	// ~ from Employee order by lastNane asc
	public List<Employee> findAllByOrderByLastNameAsc();
}
	