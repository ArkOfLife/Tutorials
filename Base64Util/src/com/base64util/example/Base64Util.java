package com.base64util.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64Util {

	public static void main(String[] args) throws IOException {
		String base64String="";
		try(FileWriter fileWriter = new FileWriter(new File("output.txt"))){
			base64String = encode("image.png");
			fileWriter.write(base64String);
		}
		
		try(FileOutputStream stream = new FileOutputStream(new File("output.png"))){
			stream.write(decode(base64String));
		}
		
		
		
	}
	
	public static String encode(String imagePath) throws IOException {
		byte[] data = Files.readAllBytes(Paths.get(imagePath));
		return Base64.getEncoder().encodeToString(data);
	}
	
	public static byte[] decode(String base64String) {
		return Base64.getDecoder().decode(base64String);
	}
	
	
	

}
