package com.montran.pojo;

public class Current extends Account {
	double overdraftBalance, actualOverdraftBalance, addOverdraftBalance;

	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int accountNumber, String name, double balance, double overdraftBalance, double actualOverdraftBalance) {
		super(accountNumber, name, balance);
		this.overdraftBalance = overdraftBalance;
		this.actualOverdraftBalance = actualOverdraftBalance;
	}

	public double getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	@Override
	public boolean withdraw(double amount) {
		if (amount > 0) {
			if (amount <= getBalance()) {
				setBalance(getBalance() - amount);
				return true;
			}

			if (amount > getBalance() && amount - getBalance() < overdraftBalance) {
				amount = amount - getBalance();
				setBalance(getBalance() - getBalance());
				overdraftBalance = overdraftBalance - amount;
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean deposit(double amount) {
		if (amount > 0) {

			if (overdraftBalance!=actualOverdraftBalance) {
				addOverdraftBalance = actualOverdraftBalance - overdraftBalance;
				
				if (addOverdraftBalance < amount) {
					overdraftBalance = overdraftBalance + addOverdraftBalance;
					amount = amount - addOverdraftBalance;
					setBalance(amount + getBalance());
					return true;
				}

				if (addOverdraftBalance >= amount) {
					overdraftBalance = overdraftBalance + amount;
					return true;
				}

			} else {
				setBalance(amount + getBalance());
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Current [actualOverdraftBalance=" + actualOverdraftBalance + ", getOverdraftBalance()="
				+ getOverdraftBalance() + ", getAccountNumber()=" + getAccountNumber() + ", getName()=" + getName()
				+ ", getBalance()=" + getBalance() + "]";
	}

	
}
