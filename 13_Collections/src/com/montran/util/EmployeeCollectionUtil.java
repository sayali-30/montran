package com.montran.util;

import com.montran.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCollectionUtil 
{
	Employee[] employees;
	
	private List<Employee> employeeList = new ArrayList<Employee>();
	private int nextIndex = 0;
	private int maxIndex;
	
	public EmployeeCollectionUtil(int empLength) 
	{		
		employees = new Employee[empLength];
		maxIndex = empLength;
	}
	
	public int getNextIndex() {
		return nextIndex;
	}
	
	public int getMaxIndex() {
		return maxIndex;
	}
	
	public boolean addNewEmployee (Employee employee)
	{
		if(nextIndex >= 0 && nextIndex < maxIndex)
		{
			employeeList.add(employee);
			nextIndex++;
			return true;
		}
		return false;
	}
	
	public boolean addAllEmployees (Employee[] employees)	
	{
		for (Employee emp : employees) 
		{
			addNewEmployee(emp);
		}
		return true;
	}
	
	public boolean updateEmployeeSalary (int employeeId, double newSalary)
	{
		for (Employee emp : employeeList) 
		{
			if(emp.getEmployeeId() == employeeId)
			{
				emp.setSalary(newSalary);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteEmployee (int employeeId)
	{
		for (Employee emp : employeeList) 
		{
			if(emp.getEmployeeId() == employeeId)
			{
				employeeList.remove(emp);
				return true;
			}
		}
		return false;
	}
	
	public Employee getEmployeeByEmployeeId (int employeeId)
	{
		for (Employee emp : employeeList) 
		{
			if(emp.getEmployeeId() == employeeId)
			{
				return emp;
			}
		}
			
		return null;
	}
	
	public List<Employee> getAllEmployees()
	{
		return employeeList;
	}
}
