package com.dev.ck.ackwd.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	public static String getRootDri() {
//		File file = new File("./");
//		String path = file.getAbsolutePath();
		
		Path currentPath = Paths.get("");
		String path = currentPath.toAbsolutePath().toString();
		return path;
	}
	
	public static Map<String, Object> savePicture(String directory, MultipartFile file, String targetTable, String diarySeq, String userId) {
		Properties properties = new Properties();
		Map<String, Object> result = new HashMap<String, Object>();
		String path = FileUtil.class.getResource("/").getPath();
		path = path + "config.properties";
		try {
			properties.load(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String filePath = properties.getProperty("file.path");
		String root = properties.getProperty("sys.root");

		String dPath = filePath + File.separator + "img" + File.separator + directory + File.separator;
		String fullPath = "";
		String fileName = "";
		Calendar cal = Calendar.getInstance();
		int pos = file.getOriginalFilename().lastIndexOf(".");
		String ext = file.getOriginalFilename().substring(pos+1);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		dPath += year + File.separator;
		dPath += month + File.separator;
		dPath += day;
		
		fullPath = root + File.separator + dPath;
		fileName = System.currentTimeMillis() + "." + ext;
		
		File drectory = new File(fullPath);
		File targetFile = new File(fullPath + File.separator + fileName);
		try {
			if(!drectory.exists() && !drectory.mkdirs()) {
				throw new IOException("디렉토리 만드는데 실패 했습니다.");
			}
			file.transferTo(targetFile);
			
			result.put("targetTable", targetTable);
			result.put("targetSeq", diarySeq);
			result.put("fileName", file.getOriginalFilename());
			result.put("fileSize", file.getSize());
			result.put("fileExt", ext);
			result.put("filePath", File.separator + dPath);
			result.put("fileFullPath", File.separator + dPath + File.separator + fileName);
			result.put("regUserId", userId);
			result.put("updUserId", userId);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
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
