package com.tlv.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputWriter extends Writer{
	
	private  OutputStream os;
	
	public FileOutputWriter(String fileName) throws FileNotFoundException{
		this.os =  new FileOutputStream(new File(fileName));
	}

	@Override
	protected OutputStream getOutputStream() {
		return os; 
	}

}
