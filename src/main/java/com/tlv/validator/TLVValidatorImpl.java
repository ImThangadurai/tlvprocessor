package com.tlv.validator;

import com.tlv.processor.Processor;

public class TLVValidatorImpl implements TLVValidator{
	
	Processor[] processors = Processor.values();

	@Override
	public boolean isValidProcessor(String processor) {
		for(Processor  p:processors){
			if(p.toString().equals(processor)){
				return true;
			}
		}
		return false;
	}

}
