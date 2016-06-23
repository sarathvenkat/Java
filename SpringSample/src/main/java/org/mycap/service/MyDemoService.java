package org.mycap.service;

import java.util.List;

import org.mycap.dto.Employee;

public interface MyDemoService 
{
	public void saveDetails(Employee employ);
	
	public List<Employee> retrieveDetails();
	
	public void deleteEmployee(Integer eid);
	
	public Employee updateEmployee(Integer eid);
}
