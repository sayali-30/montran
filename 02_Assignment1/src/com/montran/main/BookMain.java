package com.montran.main;

import com.montran.pojo.Book;
import java.io.DataInputStream;

import com.montran.pojo.Book;
import java.io.*;

public class BookMain 
{
	public static void main(String[] args) throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		
		Book book = new Book();
		
		int bkNo, n;
		String bkTitle;
		double price, total;
		
		System.out.println("\nEnter Book No. : \t");
		bkNo = Integer.parseInt(d.readLine());
		
		System.out.println("\nEnter Book Title : \t");
		bkTitle = d.readLine();
		
		System.out.println("\nEnter Book Price per copy : \t");
		price = Double.parseDouble(d.readLine());	
		
		book.input(bkNo, bkTitle, price);
		
		System.out.println("\nEnter No. of copies required : \t");
		n = Integer.parseInt(d.readLine());
		
		total = book.purchase(n);
		System.out.println("\nTotal Cost = " + total);
	}
}



/***** OUTPUT *****
Enter Book No. : 	
101

Enter Book Title : 	
The White Tiger

Enter Book Price per copy : 	
500

Enter No. of copies required : 	
6

Total Cost = 3000.0
*/