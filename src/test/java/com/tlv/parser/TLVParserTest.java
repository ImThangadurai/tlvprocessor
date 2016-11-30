package com.tlv.parser;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.tlv.pojo.TypeLengthValue;

public class TLVParserTest {

	@Test
	public void parserInputLengthTest() {
		List<TypeLengthValue > tlvs = TLVParser.parse("UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z");
		Assert.assertEquals(3, tlvs.size());
	}
	
	@Test
	public void parserTypeTest(){
		List<TypeLengthValue > tlvs = TLVParser.parse("UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z");
		Assert.assertEquals("UPPRCS", tlvs.get(0).getType());
		Assert.assertEquals("REPLCE", tlvs.get(1).getType());
		Assert.assertEquals("REPLCE", tlvs.get(2).getType());
	}
	
	@Test
	public void parserLengthTest(){
		List<TypeLengthValue > tlvs = TLVParser.parse("UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z");
		Assert.assertEquals("0008", tlvs.get(0).getLength());
		Assert.assertEquals("0003", tlvs.get(1).getLength());
		Assert.assertEquals("0001", tlvs.get(2).getLength());
	}
	
	@Test
	public void parserValueTest(){
		List<TypeLengthValue > tlvs = TLVParser.parse("UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z");
		Assert.assertEquals("Abcdefgh", tlvs.get(0).getValue());
		Assert.assertEquals("123", tlvs.get(1).getValue());
		Assert.assertEquals("Z", tlvs.get(2).getValue());
	}

}
