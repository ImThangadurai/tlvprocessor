package com.tlv.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputReader extends Reader{
	
	private  InputStream is;
	
	public FileInputReader(String fileName) throws FileNotFoundException{
		this.is = new FileInputStream(fileName);
	}

	@Override
	protected InputStream getInputStream(){
		return  is;
	}

}
