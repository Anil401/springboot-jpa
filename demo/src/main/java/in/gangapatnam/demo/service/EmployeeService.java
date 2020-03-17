package in.gangapatnam.demo.service;

import java.util.List;
import java.util.Optional;

import in.gangapatnam.demo.model.Employee;

public interface EmployeeService {
	
	public List < Employee > getAllEmployees();
	public Optional<Employee> getEmployeeById(Long employeeId);
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(Employee employee);

}
