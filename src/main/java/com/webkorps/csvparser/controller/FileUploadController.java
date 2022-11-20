package com.webkorps.csvparser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webkorps.csvparser.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file  ){
		System.out.println("--------------------------------------------");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println("--------------------------------------------");
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			 
		}
		if(!file.getContentType().equals("text/csv")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only CSV Only Parse");
		}
		fileUploadHelper.uploadFile(file);
		return ResponseEntity.ok("working");
	}
}
