package com.tlv.stream;

import java.io.OutputStream;

public class StandardOutputWriter extends Writer {

	@Override
	protected OutputStream getOutputStream() {
		return System.out;
	}

}
