package com.montran.util;

import com.montran.pojo.Employee;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabaseUtil 
{
	private List<Employee> employeeList;
	private int nextIndex = 0;
	private int maxIndex;
	
	Employee[] employees;
	Employee emp;
	
	Connection connection = null;
	PreparedStatement insertPS, updatePS, deletePS, selectOnePS;
	Statement selectAllPS;
	ResultSet resultSet;
	String sql="";
	
	public EmployeeDatabaseUtil (int empLength, Connection connection) 
	{		
		employees = new Employee[empLength];
		maxIndex = empLength;
		this.connection = connection;
	}
	
	public int getNextIndex() {
		return nextIndex;
	}
	
	public int getMaxIndex() {
		return maxIndex;
	}
	
	public boolean addNewEmployee (Employee employee) throws SQLException
	{
		if(nextIndex >= 0 && nextIndex < maxIndex)
		{
			sql = "insert into employee_records VALUES (?, ?, ?)";
			insertPS = connection.prepareStatement(sql);
			
			insertPS.setInt(1, employee.getEmployeeId());
			insertPS.setString(2, employee.getName());
			insertPS.setDouble(3,  employee.getSalary());
			
			insertPS.executeUpdate();
			
			employeeList.add(employee);
			
			nextIndex++;
			return true;
		}
		return false;
	}
	
	public boolean addAllEmployees (Employee[] employees) throws SQLException	
	{
		for (Employee emp : employees) 
		{
			addNewEmployee(emp);
		}
		return true;
	}
	
	public boolean updateEmployeeSalary (int employeeId, double newSalary) throws SQLException
	{
		sql = "select * from employee_records";
		selectAllPS = connection.createStatement();
		resultSet = selectAllPS.executeQuery(sql);
		
		while(resultSet.next())
		{
			if(resultSet.getInt("employeeId") == employeeId)
			{
				sql = "update employee_records set salary = ? where employeeId = ?";
				updatePS = connection.prepareStatement(sql);
				
				updatePS.setDouble(1, newSalary);
				updatePS.setInt(2, employeeId);
				
				updatePS.executeUpdate();
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deleteEmployee (int employeeId) throws SQLException
	{
		sql = "select * from employee_records";
		selectAllPS = connection.createStatement();
		resultSet = selectAllPS.executeQuery(sql);
		
		while(resultSet.next())
		{
			if(resultSet.getInt("employeeId") == employeeId)
			{
				sql = "delete from employee_records where employeeId = ?";
				deletePS = connection.prepareStatement(sql);
				
				deletePS.setInt(1, employeeId);
				
				deletePS.executeUpdate();
				return true;
			}
		}
		return false;
	}
	
	public Employee getEmployeeByEmployeeId (int employeeId) throws SQLException
	{
		sql = "select * from employee_records where employeeId = ?";
		selectOnePS = connection.prepareStatement(sql);
		selectOnePS.setInt(1, employeeId);
		
		resultSet = selectOnePS.executeQuery();
		
		while(resultSet.next())
		{
			emp = new Employee();
			
			emp.setEmployeeId(resultSet.getInt("employeeId"));
			emp.setName(resultSet.getString("name"));
			emp.setSalary(resultSet.getDouble("salary"));
			return emp;
		}
		
		return null;
	}
	
	public List<Employee> getAllEmployees() throws SQLException
	{
		employeeList = new ArrayList<Employee>();
		
		sql = "select * from employee_records ORDER BY employeeId";
		selectAllPS = connection.createStatement();
		
		resultSet = selectAllPS.executeQuery(sql);
		
		while(resultSet.next())
		{
			emp = new Employee();
			
			emp.setEmployeeId(resultSet.getInt("employeeId"));
			emp.setName(resultSet.getString("name"));
			emp.setSalary(resultSet.getDouble("salary"));
			employeeList.add(emp);
		}
		
		return employeeList;
	}
}
