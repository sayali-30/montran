package com.montran.util;

import java.util.Arrays;
import com.montran.pojo.Book;


public class BookUtil 
{
	private Book[] books;
	private int nextIndex = 0;
	private int maxIndex, i;
	
	public BookUtil(int booksLength) 
	{		
		books = new Book[booksLength];
		maxIndex = booksLength;
	}
	
	public int getNextIndex() {
		return nextIndex;
	}


	public int getMaxIndex() {
		return maxIndex;
	}

	public boolean addNewBook (Book book)	
	{
		if(nextIndex >= 0 && nextIndex < maxIndex)
		{
			books[nextIndex] = book;
			nextIndex++;
			return true;
		}
		return false;
	}
	
	public boolean addAllBooks (Book[] books)	
	{
		for(int i = 0; i < books.length; i++ )
		{
			addNewBook(books[i]);
		}
		return true;
	}
	
	public boolean updateBook (int bookId, String newName, double newPrice)
	{
		for(int i = 0; i < books.length; i++ )	
		{
			if(books[i].getBookId() == bookId)
			{
				books[i].setName(newName);
				books[i].setPrice(newPrice);
				
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteBook (int bookId)
	{
		for(int i = 0; i < books.length; i++ )	
		{
			if(books[i].getBookId() == bookId)
			{
				books[i] = null;
				/*for(int j = i; j < books.length; j++)
				{
					books[j] = books[j+1];
					return true;
				}*/		
				return true;
			}
			
		}
		return false;
	}
	
	public Book getBookByBookId (int bookId)
	{
		for(int i = 0; i < books.length; i++ )	
		{
			if(books[i] != null)
			{
				if(books[i].getBookId() == bookId)
				{
					return books[i];
				}
			}
			
		}
		return null;
		
		/*for(Book book : books)	
		{
			if(book != null)
			{
				if(book.getBookId() == bookId)
				{
					return book;
				}
			}
		}
		return null;*/
	}
	
	public Book[] getAllBooks()
	{
		return books;
	}
}
