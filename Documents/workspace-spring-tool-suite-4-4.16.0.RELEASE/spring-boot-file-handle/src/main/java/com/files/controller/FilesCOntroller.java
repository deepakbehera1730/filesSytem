package com.files.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.files.service.FilesService;

@RestController
public class FilesCOntroller {
	@Autowired
	private FilesService  service;
	
	@PostMapping("/file")
	public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file){
		String message=" ";
		
		try {
			service.store(file);
			message="file uploaded seccesfully "+file.getOriginalFilename()+"!";
			return new ResponseEntity<>(message,HttpStatus.OK);
		} catch (Exception e) {
			message="could not upload file"+file.getOriginalFilename()+"!";
			return new ResponseEntity<>(message,HttpStatus.EXPECTATION_FAILED);
			
		}
	}
		
//		@GetMapping("/file")
//		public ResponseEntity<List<SystemResponse>> getListFile(){
//			List<SystemResponse> files=service.getAllFiles().map(dbFile->{
//				String fileDownloadUri=ServletUriComponentsBuilder
//						.fromCurrentContextPath()
//						.path("/file/")
//						.path(dbFile.getId())
//						.toUriString();
//				
//				return new SystemResponse(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
//				
//			}).collect(Collectors.toList());
//			return ResponseEntity.status(HttpStatus.OK).body(files);
//		}
//		@GetMapping("/file/{id}")
//		public ResponseEntity<byte[]> getFile(@PathVariable String id){
//			
//			FileSystem fileSystem=service.getFile(id);
//			
//			return ResponseEntity.ok()
//			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileSystem.getName() + "\"")
//			        .body(fileSystem.getData());
//		}
}
