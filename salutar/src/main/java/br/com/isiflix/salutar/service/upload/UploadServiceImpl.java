package br.com.isiflix.salutar.service.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadServiceImpl implements IUploadService {

	@Override
	public String uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			System.out.println("DEBUG - Realizando Upload do arquivo: "+file.getOriginalFilename());
			String destinationFolder = "/Users/ynascimento/workspace";
			Path path = Paths.get(destinationFolder+ File.separator + file.getOriginalFilename());
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			return file.getOriginalFilename();
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
