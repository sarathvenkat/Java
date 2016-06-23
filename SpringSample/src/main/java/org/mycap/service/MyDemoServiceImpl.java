package org.mycap.service;

import java.util.List;

import org.mycap.dao.MyDemoDao;
import org.mycap.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyDemoServiceImpl implements MyDemoService
{

	@Autowired
	private MyDemoDao idemodao;
	
	@Transactional
	public void saveDetails(Employee employ)
	{
		idemodao.saveDetails(employ);
	}
	
	@Transactional
	public List<Employee> retrieveDetails()
	{
		return idemodao.retrieveDetails();
	}
	
	@Transactional
	public void deleteEmployee(Integer eid)
	{		
	 idemodao.deleteEmployee(eid);
	}

	@Transactional
	public Employee updateEmployee(Integer eid)
	{
		
		return idemodao.updateEmployee(eid);
	}
	
}
