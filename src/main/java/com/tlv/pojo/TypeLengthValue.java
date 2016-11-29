package com.tlv.pojo;

public class TypeLengthValue {
	
	private String type;
	private String length;
	private String value;
	
	private String processedValue;
	
	public TypeLengthValue(String tag, String length, String value) {
		super();
		this.type = tag;
		this.length = length;
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getProcessedValue() {
		return processedValue;
	}
	public void setProcessedValue(String processedValue) {
		this.processedValue = processedValue;
	}
	
	 
	

}
