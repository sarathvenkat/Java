package org.mycap.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Employee_info")
public class Employee 
{
	@Id
	@GeneratedValue
    private int emp_Id;
	@NotEmpty(message="*First Name Cannot be Null")
	private String firstName;
	private String lastName;
	@Future(message="*Date of joining should be future")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="YYYY-MM-dd")
	private Date dateofJoining;
	@Past(message="*Date of birth should be past")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="YYYY-MM-dd")
	private Date dateOfBirth;
	
	
	public Employee(){}
	
	
	public Employee(int emp_Id, String firstName, String lastName, Date dateofJoining, Date dateOfBirth) {
		super();
		this.emp_Id = emp_Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofJoining = dateofJoining;
		this.dateOfBirth = dateOfBirth;
	}
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateofJoining() {
		return dateofJoining;
	}
	public void setDateofJoining(Date dateofJoining) {
		this.dateofJoining = dateofJoining;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() 
	{
		return "Employee [emp_Id=" + emp_Id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateofJoining="
				+ dateofJoining + ", dateOfBirth=" + dateOfBirth + "]";
	}	
	
	
}
