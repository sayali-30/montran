package com.montran.pojo;

public class Book 
{
	private int bookNo;
	private String bookTitle;
	private double pricePerCopy;
	
	private double totalCost(int n)
	{
		double totalPrice = n * pricePerCopy;
		return totalPrice;
	}
	
	public void input(int bookNo, String bookTitle, double pricePerCopy)
	{
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.pricePerCopy = pricePerCopy;
	}
	
	public double purchase(int n)
	{
		return totalCost(n);
	}
	
}
