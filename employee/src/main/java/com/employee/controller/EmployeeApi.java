package com.employee.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(value = "EmployeeApi, REST APIs that deal with Employee class")
public class EmployeeApi {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/addEmployee")
	@ApiOperation(value = "Add new employee to employee service", tags = "addEmployee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Added the employee successfully"),
							@ApiResponse(code = 404, message = "Error adding employee details")})
	public String addEmployee(@RequestBody EmployeeModel employeeModel) {
		employeeService.addEmployee(employeeModel);
		return "saved...";
	}
	
	@GetMapping(value = "/getAllEmployees")
	@ApiOperation(value = "Fetch all the employees of employee service", tags = "getAllEmployees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched the employees successfully"),
							@ApiResponse(code = 404, message = "No employees found")})
	public List<EmployeeEntity> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	
	@GetMapping("/training")
    public List<Object> getTraining(){
    	String url="http://localhost:1019/training";
    	Object[] objects= restTemplate.getForObject(url, Object[].class);
    	
    	return Arrays.asList(objects);
    }

	
	
}
