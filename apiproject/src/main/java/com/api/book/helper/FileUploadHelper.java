package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR="C:\\Users\\minha\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\apiproject\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multipartFile )
	{
		boolean f = false;
		
		try {
			//READ FILE
			InputStream is = multipartFile.getInputStream();
			byte data[]= new byte[is.available()];
			is.read(data);
			
			//Write
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			
			f= true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
}
