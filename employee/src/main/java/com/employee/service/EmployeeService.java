package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;

@Service(value = "employeeService")
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public void addEmployee(EmployeeModel employeeModel) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setCity(employeeModel.getCity());
		employeeEntity.setContactNumber(employeeModel.getContactNumber());
		employeeEntity.setDob(employeeModel.getDob());
		employeeEntity.setEmployeeId(employeeModel.getEmployeeId());
		employeeEntity.setFirstName(employeeModel.getFirstName());
		employeeEntity.setLastName(employeeModel.getLastName());
		employeeEntity.setMiddleName(employeeModel.getMiddleName());
		
		employeeDao.save(employeeEntity);
	}
	
	public List<EmployeeEntity> getAllEmployees(){
		return employeeDao.findAll();
	}
}
