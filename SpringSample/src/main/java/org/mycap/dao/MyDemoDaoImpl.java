package org.mycap.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.mycap.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDemoDaoImpl implements MyDemoDao
{

	@Autowired
	private SessionFactory sessionfactory;
	
	public void saveDetails(Employee employ)
	{
		
		sessionfactory.getCurrentSession().save(employ);
		
	}
	
	public List<Employee> retrieveDetails()
	{
		
		List<Employee> employeeList=sessionfactory.getCurrentSession().createQuery("from Employee").list();
		return employeeList;
	}
	
	
	public void deleteEmployee(Integer eid)
	{
		Employee emp=(Employee)sessionfactory.getCurrentSession().get(Employee.class,eid);	
		
		if(emp!=null)
		{
			sessionfactory.getCurrentSession().delete(emp);;
		}
	}
	
	
	public Employee updateEmployee(Integer eid)
	{

	Employee emp=(Employee)sessionfactory.getCurrentSession().get(Employee.class,eid);
	
	return emp;	
	}
}
