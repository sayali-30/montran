package com.montran.main;

import com.montran.pojo.Account;
import com.montran.pojo.Current;

public class AccountMainV6 {
	public static void main(String[] args) {
		Current current = new Current(111, "Sayali", 10000, 50000, 50000);
		System.out.println(current);

		System.out.println("Withdraw = 3000");
		current.withdraw(3000);
		System.out.println(current);
		
		 // balance = 7000 overdraftbalance = 50000
		 System.out.println("Withdraw = 15000"); 
		 current.withdraw(15000);
		 System.out.println(current);
		 
		 // balance = 0 overdraftbalance = 42000
		 System.out.println("Deposit = 5000"); 
		 current.deposit(5000);
		 System.out.println(current);
		 
		 // balance = 7000 overdraftbalance = 47000
		 System.out.println("Deposit = 10000"); 
		 current.deposit(10000);
		 System.out.println(current);		 
	}
}
