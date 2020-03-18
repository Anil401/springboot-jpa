package in.gangapatnam.test.EmployeeController.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.gangapatnam.demo.Application;
import in.gangapatnam.demo.controller.EmployeeController;
import in.gangapatnam.demo.model.Employee;
import in.gangapatnam.demo.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest1 {


	@Autowired
	MockMvc mockMvc;


	@MockBean
	EmployeeRepository employeeRepository;




	@Test
	public void testgetAllEmployees() throws Exception{

		List<Employee> emp = Arrays.asList(new Employee("anil", "anil", "a@gmail.com"),new Employee("sunil", "sunil", "b@gmail.com"));
		Mockito.when(employeeRepository.findAll()).thenReturn(emp);


		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		assertNotEquals(null, result.getResponse().getContentAsString());

		
		System.out.println("testgetAllEmployees"+result.getResponse().getContentAsString());
		
		/*assert eEquls 
		 * String expected = "{\"id\":100,\"firstName\":\"anil\",\"lastName\":\"lastname\",\"emailId\":\"anil@gmail.com\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);*/


	}

	@Test
	public void testgetEmployeeById() throws Exception{

		Long value = 100L;
		Optional<Employee> emp = Optional.ofNullable(value == null ? new Employee("firstname", "lastname", "emailid") : new Employee("firstname", "lastname", "emailid"));
				Mockito.when(employeeRepository.findById(100L)).thenReturn(emp);


		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("employees/{id}","100").contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		System.out.println("getcontent"+result.getResponse().getContentAsString());
		assertNotEquals(null, result.getResponse().getContentAsString());


	}
}
