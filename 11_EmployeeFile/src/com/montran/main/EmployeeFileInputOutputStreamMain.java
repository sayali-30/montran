package com.montran.main;

import java.io.File;
import java.util.Scanner;

import com.montran.util.*;

public class EmployeeFileInputOutputStreamMain 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int choice; 
		EmployeeFileINputStreamUtil inputUtil = new EmployeeFileINputStreamUtil();
		EmployeeFileOutputStreamUtil outputUtil = new EmployeeFileOutputStreamUtil();
			
		String filePath="", data, continueChoice;
		File file = null;	
		byte[] fileData;
		int count=0;
		
		System.out.println("Hello !! \nWelcome to My Employee File");
		
		do 
		{
			System.out.println("\n--------------------------------------");
			System.out.println("\n!!.. Menu ..!! \n 1. Add Employee details into file \n 2. Read Employee details \n 3. Exit \n\n Enter your choice :\t");
			choice = scanner.nextInt();
			System.out.println("\n--------------------------------------");
			
			switch (choice) 
			{
				case 1:
				
					int employeeId;
					String name;
					double salary;
					
					if(count < 1)
					{
						System.out.println("\nEnter Path of File to add Employee details : \t");
						filePath = scanner.next();
						file = new File(filePath);
					}
										
					else if(count >= 1)
					{
						System.out.println("\nDo you want to continue with the Previous file (yes-no) : \t");
						continueChoice = scanner.next();
						
						if(continueChoice.equals("yes") || continueChoice.equals("YES") || continueChoice.equals("Yes"))
						{
							file = new File(filePath);
						}
					}
					
					scanner.nextLine();
					System.out.println("\n\n ***** Enter Employee details *****");
					
					System.out.println("\nEnter Employee Id : \t");
					employeeId = scanner.nextInt();
					
					scanner.nextLine();
					System.out.println("\nEnter Employee Name : \t");
					name = scanner.nextLine();
					
					System.out.println("\nEnter Employee Salary : \t");
					salary = scanner.nextDouble();
					
					data = employeeId + "\t\t" + name + "\t" + salary + "\n";
					outputUtil.writeDataIntoFile(file, data.getBytes());
					
					System.out.println("\n\nPlease check your file..");
					
					count++;
					
				break;
	
				case 2:
						
					if(count < 1)
					{
						scanner.nextLine();
						System.out.println("\nEnter Path of File to be read : \t ");
						filePath = scanner.nextLine();
						file = new File(filePath);
					}
					
					else if(count >= 1)
					{
						System.out.println("\nDo you want to continue with the Previous file (yes-no) : \t");
						continueChoice = scanner.next();
						
						if(continueChoice.equals("yes") || continueChoice.equals("YES") || continueChoice.equals("Yes"))
						{
							file = new File(filePath);
						}
					}
					
					fileData = inputUtil.getFileData(file);
					
					System.out.println("\n\n ***** Employee Details ***** \n\nEmployee Id \t Name \t\t Salary \n");
					for(byte b : fileData)
						System.out.print((char)b);
					
					count++;
					
				break;
	
				case 3:
					System.out.println("\nThank you !!");
					System.exit(0);
				break;
				
				default:
					System.out.println("\n\nInvalid Choice");
				break;
			}
		} while(choice != 3);
		
		scanner.close();
	}
}
