package com.tlv.main;

import com.tlv.processor.TLVProcessor;
import com.tlv.stream.Reader;
import com.tlv.stream.StandardInputReader;
import com.tlv.stream.StandardOutputWriter;
import com.tlv.stream.Writer;

public class Main {
	
	
	public static void main(String args[]){
		Reader reader = null;
		Writer writer = null;
		
		try{
			reader = new StandardInputReader();
			writer = new StandardOutputWriter();
			
			TLVProcessor processor = new TLVProcessor(reader, writer);
			processor.process();
			
		}catch(Exception exception){
			System.out.println("Error Occured while procesing");
			exception.printStackTrace();
		}finally{
			if(reader!=null)
				reader.close();
			if(writer!=null)
				writer.close();
		}
	
	}
}
