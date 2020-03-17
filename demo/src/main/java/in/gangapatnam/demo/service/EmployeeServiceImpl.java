package in.gangapatnam.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gangapatnam.demo.model.Employee;
import in.gangapatnam.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	public List < Employee > getAllEmployees() {
		return employeeRepository.findAll();
	}


	public Optional<Employee> getEmployeeById(Long employeeId){
		return  employeeRepository.findById(employeeId);
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	public void deleteEmployee(Employee employee){
		employeeRepository.delete(employee);
	}

}
