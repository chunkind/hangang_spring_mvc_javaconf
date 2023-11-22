package com.dev.ck.cltsh.cmm.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static void uploadFile(HttpServletRequest req, MultipartFile file) {
		String saveDir = req.getServletContext().getInitParameter("uploadPath");
		String tomcatPath = req.getServletContext().getInitParameter("tomcatPath");
		String imgPath = "/img/cltsh/";
		
		//path 설정
		String path = req.getRequestURI();
		if(path.contains("dressRegisterAct.do")) {
			saveDir += "reviews/";
			tomcatPath += "reviews/";
			imgPath += "reviews/";
		}
		
		String fileName = file.getOriginalFilename();
		if (file.getSize() > 0) {
			System.out.println("saveDir:" + saveDir + File.separator + fileName);
			System.out.println("tomcatPath:" + tomcatPath + File.separator + fileName);
			
			File saveFile = new File(saveDir + File.separator + fileName);
			File tomcatFile = new File(tomcatPath + File.separator + fileName);
			
			try {
				file.transferTo(saveFile);
				Files.copy(saveFile.toPath(), tomcatFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//				file.transferTo(tomcatFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			req.setAttribute("imgPath", imgPath);
			req.setAttribute("imgNm", fileName);
		}
	}
}
