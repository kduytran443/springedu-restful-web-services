package com.duyb1906443.utils;

import java.io.FileInputStream;
import org.apache.tomcat.util.codec.binary.Base64;
import java.io.IOException;

public class ByteToBase64 {
	
	public static String byteToBase64(byte[] file) throws IOException {
		StringBuilder sb = new StringBuilder(file.length / 3 * 4);

		FileInputStream fin = null;
		try {
		    fin = new FileInputStream("some.file");
		    // Max size of buffer
		    int bSize = 3 * 512;
		    // Buffer
		    byte[] buf = new byte[bSize];
		    // Actual size of buffer
		    int len = 0;

		    while((len = fin.read(buf)) != -1) {
		        byte[] encoded = Base64.encodeBase64(buf);

		        // Although you might want to write the encoded bytes to another 
		        // stream, otherwise you'll run into the same problem again.
		        sb.append(new String(buf, 0, len));
		    }
		} catch(IOException e) {
		    if(null != fin) {
		        fin.close();
		    }
		}

		String base64EncodedFile = sb.toString();
		return base64EncodedFile;
	}
	
}
