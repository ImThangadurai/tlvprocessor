package com.tlv.processor;

import java.util.List;

import com.tlv.constants.TLVConstants;
import com.tlv.parser.TLVParser;
import com.tlv.pojo.TypeLengthValue;
import com.tlv.stream.Reader;
import com.tlv.stream.Writer;
import com.tlv.validator.TLVValidator;
import com.tlv.validator.TLVValidatorImpl;

public class TLVProcessor {
	
	private Reader reader = null;
	private Writer writer = null;
	
	public TLVProcessor(Reader reader, Writer writer){
		this.reader = reader;
		this.writer = writer;
	}
	
	public void process(){
		
		reader.initialize();
		writer.initialize();
		
		while(reader.hasNext()){

			String input = reader.read();
			
			List<TypeLengthValue> list = TLVParser.parse(input);
			
			for(TypeLengthValue tlv:list){
				
				TLVValidator validator = new TLVValidatorImpl();
				
				if(validator.isValidProcessor(tlv.getType().toUpperCase())){
					Processor type = Processor.valueOf(tlv.getType().toUpperCase());
					type.process(tlv);
					writer.write(tlv.getType()+TLVConstants.DELIMITER+tlv.getProcessedValue());
				}else{
					writer.write(TLVConstants.TYPE_NOT_VALID);
				}
			}
		}
	}
}
