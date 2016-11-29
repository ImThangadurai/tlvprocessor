package com.tlv.stream;

import java.io.InputStream;

public class StandardInputReader extends Reader {

	@Override
	protected InputStream getInputStream() {
		return System.in;
	}

}
