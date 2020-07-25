package com.montran.main;

import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeCollectionMainV2 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		EmployeeCollectionUtil util = new EmployeeCollectionUtil(1000);
		List<Employee> employeeList = null;
		Employee employee;
		Employee[] employees;
		
		int employeeId, choice, numberOfEmployees;
		String name;
		double salary, newSalary;
		boolean result;

		System.out.println("Hello !! \nWelcome to My Employee List");
		
		do 
		{
			employeeList = util.getAllEmployees();
			
			if(employeeList.size() > 0)
			{
				System.out.println("\n\n\n------ Available Employee Details ------");
				System.out.println("\nEmployee Id \tEmployee Name \t\tEmployee Salary\n");
				
				for (Employee emp : employeeList) 
					if(emp != null)
						System.out.println(emp.getEmployeeId() + "\t\t" + emp.getName() + "\t\t" + emp.getSalary());
				
			}
			else if(employeeList.size() <= 0)
				System.out.println("\n\nNo Employee Records Found !!");
			
			System.out.println("\n\n !!.. Menu ..!! \n 1. Add Single Employee \n 2. Add Multiple Employees \n 3. Update Existing Employee Salary \n 4. Delete Existing Employee \n 5. Print Single Employee Details \n 6. Exit \n\n Enter your choice :\t");
			choice = scanner.nextInt();
			
			//System.out.println("\nList Size = " + employeeList.size());

			switch (choice) 
			{
				case 1:
				
					System.out.println("\nEnter Employee Id : \t");
					employeeId = scanner.nextInt();
					
					scanner.nextLine();
					System.out.println("\nEnter Name : \t");
					name = scanner.nextLine();

					System.out.println("\nEnter Salary : \t");
					salary = scanner.nextDouble();
					
					employee = new Employee(employeeId, name, salary);
	
					result = util.addNewEmployee(employee);
	
					if (result)
					{
						System.out.println("\nEmployee Added Successfully \n");
						System.out.println(employee);
					}
					else
						System.out.println("\nEmployee Addition Failed");
	
				break;
	
				case 2:
					
					System.out.println("\n\nEnter the number of Employees you want to add : \t");
					numberOfEmployees = scanner.nextInt();
					
					System.out.println(util.getMaxIndex() - util.getNextIndex());
					
					if(numberOfEmployees <= util.getMaxIndex() - util.getNextIndex())
					{					
						employees = new Employee[numberOfEmployees];
						
						for(int i = 0; i < numberOfEmployees; i++)
						{
							System.out.println("\n\n*** Enter Employee No. " + (i+1) + "***");
							
							System.out.println("\nEnter Employee Id : \t");
							employeeId = scanner.nextInt();
							
							scanner.nextLine();
							System.out.println("\nEnter Name : \t");
							name = scanner.nextLine();

							System.out.println("\nEnter Salary : \t");
							salary = scanner.nextDouble();
							
							employee = new Employee(employeeId, name, salary);
							employees[i] = employee;
							
							System.out.println("\n-------------------------------------------------");
						}
						util.addAllEmployees(employees);
						System.out.println("\nEmployees are added successfully");
					}
					else
						System.out.println("\nNo Space Available");
				break;
	
				case 3:
					
					System.out.println("\n\nEnter Employee Id : \t");
					employeeId = scanner.nextInt();
					
					employee = util.getEmployeeByEmployeeId(employeeId);
					
					if(employee != null)
					{
						System.out.println(employee);
						
						System.out.println("\nEnter New Salary : \t");
						newSalary = scanner.nextDouble();
							
						result = util.updateEmployeeSalary(employeeId, newSalary);
		
						if (result)
						{
							System.out.println("\nEmployee Updated Successfully");
							System.out.println(employee);
						}
						else
							System.out.println("\nEmployee Updation Failed");
					}
					else
						System.out.println("\nEmployee Not Found !! Invalid Employee Id..");
				break;
				
				case 4:
					
					System.out.println("\n\nEnter Employee Id : \t");
					employeeId = scanner.nextInt();

					employee = util.getEmployeeByEmployeeId(employeeId);
					
					if(employee != null)
					{
						result = util.deleteEmployee(employeeId);
						
						if (result)
							System.out.println("\nEmployee Deleted Successfully");
						else
							System.out.println("\nEmployee Deletion Failed");
					}
					else
						System.out.println("\nEmployee Not Found !! Invalid Employee Id..");
				break;
				
				case 5:
					
					System.out.println("\n\nEnter Employee Id : \t");
					employeeId = scanner.nextInt();
					
					employee = util.getEmployeeByEmployeeId(employeeId);
					
					if(employee != null)
					{
						System.out.println("\nEmployee Found ..!!");
						System.out.println(employee);
					}
					else
						System.out.println("\nEmployee Not Found !! Invalid Employee Id..");
				break;
	
				case 6:
					System.out.println("\nThank you !!");
					System.exit(0);
				break;
				
				default:
					System.out.println("\n\nInvalid Choice");
				break;
			}

		} while(choice != 6);
		
		scanner.close();
	}
}
