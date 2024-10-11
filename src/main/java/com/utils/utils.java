package com.utils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class utils {
	public static String displayImage(InputStream is) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while( (bytesRead = is.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		byte[] imagebytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imagebytes);
		return base64Image;
	}
}
