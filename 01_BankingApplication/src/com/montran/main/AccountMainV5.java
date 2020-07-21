package com.montran.main;

import java.util.Scanner;
import com.montran.pojo.Savings;
import com.montran.pojo.Current;

public class AccountMainV5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int accountNumber, transactionChoice, accountChoice;
		String name, continueChoice;
		double balance, overdraftBalance, amount, actualOverdraftBalance;
		boolean result, isSalary = false;

		System.out.println("Hello !! \nWelcome to XYZ bank");
		
		System.out.println("\n\n...Menu... \n 1. Savings \n 2. Current \n\n Enter your choice :\t");
		accountChoice = scanner.nextInt();
		
		System.out.println("\n\nEnter Account No. : \t");
		accountNumber = scanner.nextInt();

		System.out.println("\nEnter Name : \t");
		name = scanner.next();

		System.out.println("\nEnter Balance : \t");
		balance = scanner.nextDouble();

		switch (accountChoice) {
		case 1:
			System.out.println("\n\nDo you want to open Salary account (true - false) : \t");
			isSalary = scanner.nextBoolean();

			Savings savings = new Savings(accountNumber, name, balance, isSalary);

			do {
				System.out.println(
						"\n\n !!! Menu !!! \n 1. Withdraw \n 2. Deposit \n 3. Check Balance \n 4. Exit \n\n Enter your choice : \t");
				transactionChoice = scanner.nextInt();

				switch (transactionChoice) {
				case 1:
					System.out.println("\n Enter amount to withdraw");
					amount = scanner.nextInt();

					result = savings.withdraw(amount);

					if (result)
						System.out.println("\nTransaction successful");
					else
						System.out.println("\nTransaction failed");

					System.out.println(savings);
					break;

				case 2:
					System.out.println("\n Enter amount to deposit");
					amount = scanner.nextInt();

					result = savings.deposit(amount);

					if (result)
						System.out.println("\nTransaction successful");
					else
						System.out.println("\nTransaction failed");

					System.out.println(savings);
					break;

				case 3:
					System.out.println(savings);
					break;

				default:
					System.out.println("\nInvalid Choice");
					break;
				}

				System.out.println("\n\n Do you want to continue ? (yes - no)\t");
				continueChoice = scanner.next();

			} while (continueChoice.equals("yes") || continueChoice.equals("YES") || continueChoice.equals("Yes"));
			// }while (transactionChoice == 4);
			
			if(continueChoice.equals("no")  || continueChoice.equals("NO") || continueChoice.equals("No"))
				System.out.println("\n\nThank You For Banking With Us !!");

			break;

		case 2:
			System.out.println("\n\nEnter Overdraft Balance : \t");
			overdraftBalance = scanner.nextDouble();
			
			System.out.println("\n\nEnter Overdraft Balance Limit : \t");
			actualOverdraftBalance = scanner.nextDouble();

			Current current = new Current(accountNumber, name, balance, overdraftBalance, actualOverdraftBalance);

			do {
				System.out.println(
						"\n\n !!! Menu !!! \n 1. Withdraw \n 2. Deposit \n 3. Check Balance \n 4. Exit \n\n Enter your choice : \t");
				transactionChoice = scanner.nextInt();

				switch (transactionChoice) {
				case 1:
					System.out.println("\n Enter amount to withdraw");
					amount = scanner.nextDouble();

					result = current.withdraw(amount);

					if (result)
						System.out.println("\nTransaction successful");
					else
						System.out.println("\nTransaction failed");

					System.out.println(current);
					break;

				case 2:
					System.out.println("\n Enter amount to deposit");
					amount = scanner.nextDouble();

					result = current.deposit(amount);

					if (result)
						System.out.println("\nTransaction successful");
					else
						System.out.println("\nTransaction failed");

					System.out.println(current);
					break;

				case 3:
					System.out.println(current);
					break;

				default:
					System.out.println("\n\nInvalid Choice");
					break;
				}

				System.out.println("\n\n Do you want to continue ? (yes - no)\t");
				continueChoice = scanner.next();

			} while (continueChoice.equals("yes") || continueChoice.equals("YES") || continueChoice.equals("Yes"));
			// }while (transactionChoice == 4);
			
			if(continueChoice.equals("no")  || continueChoice.equals("NO") || continueChoice.equals("No"))
				System.out.println("\n\nThank You For Banking With Us !!");
			
		break;
						
		default:
			System.out.println("\n\nInvalid Choice");
		break;
		}
		
		scanner.close();
	}
}
