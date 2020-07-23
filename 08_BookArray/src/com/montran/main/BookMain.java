package com.montran.main;

import java.util.Scanner;

import com.montran.util.BookUtil;
import com.montran.pojo.Book;

public class BookMain 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int choice, bookId, numberOfBooks=0;
		String name, newName, continueChoice;
		double price, newPrice;
		boolean result;
		
		BookUtil bookUtil = new BookUtil(100);
		Book books[] = null;
		Book book;
		
		System.out.println("Hello !! \nWelcome to My Library");
		
		do 
		{
			books = bookUtil.getAllBooks();
			
			System.out.println("\n\n------ Available Book Details ------\n");
			
			for(Book bookTemp : books)
				if(bookTemp != null)
					System.out.println("\nBook Id \tBook Name \tBook Price \n" + bookTemp.getBookId() + "\t\t" + bookTemp.getName() + "\t\t" + bookTemp.getPrice());
			
			System.out.println("\n\n!!.. Menu ..!! \n 1. Add Single Book \n 2. Add Multiple Books \n 3. Update Existing Book \n 4. Delete Existing Book \n 5. Print Single Book Details \n 6. Exit \n\n Enter your choice :\t");
			choice = scanner.nextInt();

			switch (choice) 
			{
				case 1:
				
					System.out.println("\n\nEnter Book Id : \t");
					bookId = scanner.nextInt();
					scanner.nextLine();
	
					System.out.println("\nEnter Book Name : \t");
					name = scanner.nextLine();
	
					System.out.println("\nEnter Price : \t");
					price = scanner.nextDouble();
					
					book = new Book(bookId, name, price);
	
					result = bookUtil.addNewBook(book);
	
					if (result)
						System.out.println("\nBook Added Successfully");
					else
						System.out.println("\nBook Addition Failed");
	
					System.out.println(book);
				break;
	
				case 2:
					
					System.out.println("\n\nEnter the number of books you want to add : \t");
					numberOfBooks = scanner.nextInt();
					
					if(numberOfBooks < bookUtil.getMaxIndex() - bookUtil.getNextIndex())
					{
						books = new Book[numberOfBooks];
						
						for(int i = 0; i < numberOfBooks; i++)
						{
							System.out.println("\n\n*** Enter Book No. " + (i+1) + "***");
							
							System.out.println("\nEnter Book Id : \t");
							bookId = scanner.nextInt();
							scanner.nextLine();
			
							System.out.println("\nEnter Book Name : \t");
							name = scanner.nextLine();
			
							System.out.println("\nEnter Price : \t");
							price = scanner.nextDouble();
							
							book = new Book(bookId, name, price);
							books[i] = book;
							
							System.out.println("\n-------------------------------------------------");
						}
						bookUtil.addAllBooks(books);
						System.out.println("\nBooks are added successfully");
					}
					else
						System.out.println("\nNo Space Available");
				break;
	
				case 3:
					
					System.out.println("\n\nEnter Book Id : \t");
					bookId = scanner.nextInt();
					
					book = bookUtil.getBookByBookId(bookId);
					
					if(book != null)
					{
						System.out.println(book);
						
						scanner.nextLine();
						
						System.out.println("\nEnter New Book Name : \t");
						newName = scanner.nextLine();
		
						System.out.println("\nEnter New Price : \t");
						newPrice = scanner.nextDouble();
							
						result = bookUtil.updateBook(bookId, newName, newPrice);
		
						if (result)
							System.out.println("\nBook Updated Successfully");
						else
							System.out.println("\nBook Updation Failed");
					}
					else
						System.out.println("\nNo book found");
				break;
				
				case 4:
					
					System.out.println("\n\nEnter Book Id : \t");
					bookId = scanner.nextInt();
					
					book = bookUtil.getBookByBookId(bookId);
					
					if(book != null)
					{
						result = bookUtil.deleteBook(bookId);
						
						if (result)
							System.out.println("\nBook Deleted Successfully");
						else
							System.out.println("\nBook Deletion Failed");
					}
					else
						System.out.println("\nNo book found");
				break;
				
				case 5:
					
					System.out.println("\n\nEnter Book Id : \t");
					bookId = scanner.nextInt();
					
					book = bookUtil.getBookByBookId(bookId);
					
					if(book != null)
					{
						System.out.println(book);
					}
					else
						System.out.println("\nNo book found");
				break;
	
				case 6:
					System.out.println("\nThank you !!");
					System.exit(0);
				break;
				
				default:
					System.out.println("\n\nInvalid Choice");
				break;
			}

			System.out.println("\n\n Do you want to continue ? (yes - no)\t");
			continueChoice = scanner.next();

		} while(continueChoice.equals("yes") || continueChoice.equals("YES") || continueChoice.equals("Yes"));
		
		if (continueChoice.equals("no") || continueChoice.equals("NO") || continueChoice.equals("No"))
			System.out.println("\n\nThank You !!");

		scanner.close();
	}
}
