package br.com.isiflix.salutar.service.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

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
			String extension  = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String newFileName = UUID.randomUUID().toString()+extension;
			
			
			Path path = Paths.get(destinationFolder+ File.separator + newFileName);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			return newFileName;
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
