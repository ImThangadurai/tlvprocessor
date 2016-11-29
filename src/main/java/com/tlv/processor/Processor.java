package com.tlv.processor;

import com.tlv.constants.TLVConstants;
import com.tlv.pojo.TypeLengthValue;

public enum Processor {
	
	REPLCE{
		@Override
		public void process(TypeLengthValue tlv) {
			tlv.setProcessedValue(TLVConstants.REPLACE_WITH);
		}
	},
	
	UPPRCS{
		@Override
		public void process(TypeLengthValue tlv) {
			tlv.setProcessedValue(tlv.getValue().toUpperCase());
		}
	};
	
	public abstract void process(TypeLengthValue tlv);
}
