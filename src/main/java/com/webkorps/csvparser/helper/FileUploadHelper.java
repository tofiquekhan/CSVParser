package com.webkorps.csvparser.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR="C:\\tofique\\CSVParser\\src\\main\\resources\\static\\files";
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean flag = false;
		try {
			
			InputStream in = multipartFile.getInputStream();
			byte data[] = new byte[in.available()];
			in.read(data);
			for(byte b : data) {
				System.out.println((char)b);
			}
			
			flag = true;
			
//			Files.copy(multipartFile.getInputStream(), UPLOAD_DIR+File, null)
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
