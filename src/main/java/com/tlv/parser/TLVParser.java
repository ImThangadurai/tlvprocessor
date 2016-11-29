package com.tlv.parser;

import java.util.ArrayList;
import java.util.List;

import com.tlv.constants.TLVConstants;
import com.tlv.pojo.TypeLengthValue;

public class TLVParser {
	
	public static List<TypeLengthValue> parse(String input){
		
		List<TypeLengthValue> list =  new ArrayList<TypeLengthValue>();

		int totalLength =  input.length();
		
		int begin = 0;

		while(begin!=totalLength){
			
			int end = begin+TLVConstants.TAG_LENGTH;
			
			String type = substring(input, begin, end);
			
			begin = end+1;
			end = begin+TLVConstants.LENGTH_LENGTH;
			
			String length = substring(input, begin, end);
			
			begin = end+1;
			int l = Integer.parseInt(length);
			end = begin+l;
			
			String value = substring(input, begin, end);
			
			list.add(new TypeLengthValue(type, length, value));
			
			begin = begin + l;
			
		}
		
		return list;
		
	}
	
	private static String substring(String input, int begin, int end){
		
		return new StringBuilder(input.substring(begin, end)).toString();
		
	}

}
