package com.tlv.stream;

import java.io.InputStream;
import java.util.Scanner;

public abstract class Reader {
	
	private Scanner scanner;
	
	public Reader(){
	}
	
	public void initialize(){
		scanner = new Scanner(getInputStream());
	}
	
	public String read(){
		return scanner.nextLine();
	}
	
	public boolean hasNext(){
		return scanner.hasNext();
	}
	
	public void close(){
		if(scanner!=null)
			scanner.close();
	}
	
	//factory method
	protected abstract InputStream getInputStream();

}
