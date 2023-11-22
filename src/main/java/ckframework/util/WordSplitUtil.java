package ckframework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WordSplitUtil {
	public static void main(String[] args) throws Exception {
		System.out.println("Program start....");

		//프로잭트 폴더 주소 출력
		File path = new File(".");
		System.out.println(path.getAbsolutePath());

		String path2 = WordSplitUtil.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
		System.out.println(path2); //--> 절대 경로가 출력됨
		File fileInSamePackage = new File(path + "wordSplit.txt"); // path 폴더 내의 test.txt 를 가리킨다.

		//콘솔 입력
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int result = Integer.parseInt(br.readLine());
//		br.close();
		//파일 입력
		BufferedReader br_f = new BufferedReader(new FileReader("/Users/ck/git/hangang_spring_mvc_javaconf/src/main/java/com/dev/ck/util/wordSplit.txt"));
		String line = "";

		List<String> strList = new ArrayList<String>();
		for(int i=1; (line = br_f.readLine()) != null; i++){
			strList.add(line);
		}

		List<Word> wordList = new ArrayList<Word>();
		for(String str : strList){
			Word word = new Word();
			String[] strs = str.split(" ");
			String price = "";
			String name = "";
			for(int i=0; i<strs.length; i++){
				if(i == 0){
					price = strs[i];
				}else{
					name += strs[i] + " ";
				}
			}
			word.setPrice(price);
			word.setName(name);
			wordList.add(word);
		}

		for(int i=0; i<wordList.size(); i++){
//			System.out.println(wordList.get(i).getPrice());
			System.out.println(wordList.get(i).getName());
		}

		System.out.println("Program end....");
	}
}


class Word{
	String price;
	String name;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}