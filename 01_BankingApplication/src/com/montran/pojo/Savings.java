package com.montran.pojo;

//savings "is-a" account
public class Savings extends Account {
	private boolean isSalary;
	double minimumBalance = 500;

	public Savings() {
		System.out.println("\nDefault Constructor of Savings..");
	}

	/*
	 * public Savings(int accountNumber, String name, double balance, boolean
	 * isSalary) { System.out.println("\nParameterised constructor of Savings !!");
	 * }
	 */ // will call default constructor of base class even agter providing values

	/*
	 * public Savings(int accountNumber, String name, double balance, boolean
	 * isSalary) { super(accountNumber, name, balance);
	 * System.out.println("\nParameterised constructor of Savings !!"); }
	 */ // now this will call the parameterised constructor of account due to SUPER

	public Savings(int accountNumber, String name, double balance, boolean isSalary) {
		super(accountNumber, name, balance);
		this.isSalary = isSalary;
	}

	public boolean isSalary() {
		return isSalary;
	}

	public void setSalary(boolean isSalary) {
		this.isSalary = isSalary;
	}

	@Override
	public boolean withdraw(double amount) {
		if (amount > 0) {
			if (isSalary && amount <= getBalance()) {
				setBalance(getBalance() - amount);
				return true;
			}

			if (isSalary == false && getBalance() - amount >= minimumBalance) {
				setBalance(getBalance() - amount);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		if (amount > 0) {
			setBalance(getBalance() + amount);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Savings [isSalary=" + isSalary + ", getAccountNumber()=" + getAccountNumber() + ", getName()="
				+ getName() + ", getBalance()=" + getBalance() + "]";
	}
}
