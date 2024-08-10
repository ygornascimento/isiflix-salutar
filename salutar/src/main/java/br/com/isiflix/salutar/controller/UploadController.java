package br.com.isiflix.salutar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.isiflix.salutar.dto.PathToFile;
import br.com.isiflix.salutar.service.upload.IUploadService;

@RestController
@CrossOrigin("*")
public class UploadController {
	
	@Autowired
	private IUploadService service;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFiles(@RequestParam(name="file") MultipartFile file) {
		String filename = service.uploadFile(file);
		if (filename != null) {
			return ResponseEntity.status(201).body(new PathToFile(filename));
		}
		
		return ResponseEntity.badRequest().build();
	}
}
