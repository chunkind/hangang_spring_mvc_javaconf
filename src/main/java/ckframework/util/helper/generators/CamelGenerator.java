package ckframework.util.helper.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.jdbc.support.JdbcUtils;


public class CamelGenerator {
	public static void main(String[] args) throws Exception {
		
		createObject("a");
		
	}
	
	public static void createObject(String className) throws Exception{
		File file = new File("C:\\work\\workspace\\02_Application\\src\\test\\java\\ehimart\\app\\domain\\bo\\drc\\common\\util\\generator\\sample.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(fileReader);
		
		String line = "";
		while((line = bufReader.readLine()) != null){
			System.out.println("private String "+JdbcUtils.convertUnderscoreNameToPropertyName(line));
		}
		bufReader.close();
	}
}
