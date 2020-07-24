package com.montran.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class EmployeeFileINputStreamUtil 
{
	private byte[] data;
	private int fileLength;
	private InputStream inputStream;
	
	public byte[] getFileData (File file)
	{
		try
		{
			fileLength = (int)file.length();
			data = new byte[fileLength];
			inputStream = new FileInputStream(file);
			inputStream.read(data);
			return data;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found Exception : "+ e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("IO Exception : "+ e.getMessage());
		}
		
		finally
		{
			try
			{
				inputStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Exception : "+ e.getMessage());
			}
		}
		
		return null;
	}

}