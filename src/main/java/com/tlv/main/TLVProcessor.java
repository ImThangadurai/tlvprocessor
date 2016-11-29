package com.tlv.main;

import java.util.List;

import com.tlv.constants.TLVConstants;
import com.tlv.parser.TLVParser;
import com.tlv.pojo.TypeLengthValue;
import com.tlv.processor.Processor;
import com.tlv.stream.Reader;
import com.tlv.stream.StandardInputReader;
import com.tlv.stream.StandardOutputWriter;
import com.tlv.stream.Writer;
import com.tlv.validator.TLVValidator;
import com.tlv.validator.TLVValidatorImpl;

public class TLVProcessor {
	
	
	public static void main(String args[]){
		Reader reader = null;
		Writer writer = null;
		
		try{
			reader = new StandardInputReader();
			writer = new StandardOutputWriter();
			while(reader.hasNext()){
				String input = reader.read();
				List<TypeLengthValue> list = TLVParser.parse(input);
				for(TypeLengthValue tlv:list){
					
					TLVValidator validator = new TLVValidatorImpl();
					
					if(validator.isValidProcessor(tlv.getType().toUpperCase())){
						Processor processor = Processor.valueOf(tlv.getType().toUpperCase());
						processor.process(tlv);
						writer.write(tlv.getType()+TLVConstants.DELIMITER+tlv.getProcessedValue());
					}else{
						writer.write("Type not valid");
					}
				}
			}
		}finally{
			System.out.println("Inside finally");
			if(reader!=null)
				reader.close();
			if(writer!=null)
				writer.close();
		}
	
	}
}
