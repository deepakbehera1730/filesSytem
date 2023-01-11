package com.files.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.files.entity.FilesEntity;
import com.files.repository.FilesRepository;

@Service
public class FilesService {
	
	@Autowired
	private FilesRepository filesRepository;
	
	public FilesEntity store(MultipartFile file)throws IOException{
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		FilesEntity fileSystem=new FilesEntity(fileName, file.getContentType(), file.getBytes());
		return filesRepository.save(fileSystem);
	}
}
