package com.duyb1906443.utils;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ByteToBase64 {
	
	public static String byteToBase64(MultipartFile multipartFile) throws IOException {
		byte[] bytes = multipartFile.getBytes();
		return new String(bytes);
	}
	
}
