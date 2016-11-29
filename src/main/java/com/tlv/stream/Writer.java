package com.tlv.stream;

import java.io.OutputStream;
import java.io.PrintWriter;

public abstract class Writer {
	
	private PrintWriter writer;
	
	public Writer(){
		writer =  new PrintWriter(getOutputStream());
	}
	
	public void write(String value){

		writer.println(value);
		writer.flush();
	}
	
	public void close(){
		if(writer!=null)
			writer.close();
	}

	
	//factory method
	protected abstract OutputStream getOutputStream();
	
}
