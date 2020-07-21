package com.montran.pojo;

public class Account extends Object {
	private int accountNumber; // instance variable
	private String name;
	private double balance;

	public Account() {
		System.out.println("\nDefault constructor of Account");
	}

	public Account(int accountNumber, String name, double balance) {
		System.out.println("\nParameterised constructor of Account");
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public void set(int accountNumber, String name, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	} // extra

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			return true;
		}

		return false;
	}

	public boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance = balance - amount;
			return true;
		}

		return false;
	}

	@Override // annotation (not compulsory)
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
}
