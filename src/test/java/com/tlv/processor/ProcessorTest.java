package com.tlv.processor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.tlv.parser.TLVParser;
import com.tlv.pojo.TypeLengthValue;

public class ProcessorTest {


	@Test
	public void replaceTest() {
		List<TypeLengthValue > tlvs = TLVParser.parse("REPLCE-0003-123");
		
		TypeLengthValue tlv = tlvs.get(0);
		
		String type = tlv.getType();
		
		Processor processor =  Processor.valueOf(type);
		processor.process(tlv);
		
		Assert.assertEquals("THIS STRING", tlv.getProcessedValue());
	}
	
	@Test
	public void upperCaseTest() {
		List<TypeLengthValue > tlvs = TLVParser.parse("UPPRCS-0008-Abcdefgh");
		
		TypeLengthValue tlv = tlvs.get(0);
		
		String type = tlv.getType();
		
		Processor processor =  Processor.valueOf(type);
		processor.process(tlv);
		
		Assert.assertEquals("ABCDEFGH", tlv.getProcessedValue());
	}

}
