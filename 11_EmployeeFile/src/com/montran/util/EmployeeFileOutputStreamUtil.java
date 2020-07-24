package com.montran.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EmployeeFileOutputStreamUtil 
{
	private OutputStream outputStream;
	
	public void writeDataIntoFile(File file, byte[] data)
	{
		try
		{
			outputStream = new FileOutputStream(file, true);
			outputStream.write(data);
		}
		catch (FileNotFoundException e)
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
				outputStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Exception : "+ e.getMessage());
			}
		}
	}
}
