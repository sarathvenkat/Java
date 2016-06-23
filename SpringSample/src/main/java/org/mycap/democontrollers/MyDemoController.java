package org.mycap.democontrollers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.mycap.dto.Employee;
import org.mycap.service.MyDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyDemoController 
{

	@Autowired
	private MyDemoService imydemoservice;
	
	@RequestMapping("/demo")
	public String wishingMethod(ModelMap map)
	{
		map.put("employ",new Employee());
		
		List<Employee> listEmployee=imydemoservice.retrieveDetails();
	    System.out.println(listEmployee);
		
		map.put("employed", imydemoservice.retrieveDetails());
		return "techjoy";
	}
	
	@RequestMapping("/saveEmployee")
	public String saveDetails(@Valid @ModelAttribute("employ") Employee emp,BindingResult result,ModelMap map)
	{
		//emp.getDateOfBirth().getTime();
		
		System.out.println(" hello ");
		
		//Date date=new Date(emp.getDateOfBirth().getTime());
		
		imydemoservice.saveDetails(emp);
		
		List<Employee> employeeList=imydemoservice.retrieveDetails();
		
		map.put("employed", employeeList);
		return "techjoy";
	}
	
	
	@RequestMapping("/edit/{emp_Id}")
	public String editEmployee(@PathVariable("emp_Id") Integer eid,ModelMap map)
	{
		
		List<Employee> employeeList=imydemoservice.retrieveDetails();
				
		Employee employid=imydemoservice.updateEmployee(eid);
		
		map.put("employ",employid);
		map.put("employed", employeeList);
		
		return "techjoy";
	}
	
	@RequestMapping("/delete/{emp_Id}")
	public String deleteEmployee(@PathVariable("emp_Id") Integer eid,ModelMap map)
	{
		imydemoservice.deleteEmployee(eid);
		
		List<Employee> employeeList=imydemoservice.retrieveDetails();
		
		System.out.println(employeeList);
		if(employeeList.equals("[]"))
		{
			map.put("employ", new Employee());
			return "techjoy";
			
		}
		else
		{
		map.put("employed", employeeList);
		map.put("employ", new Employee());
				
		return "techjoy";
		}
	}
	
}
