package com.dev.ck;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public static String RESULT_CD = "resultCd"; //성공:S, 실패:F
	public static String RESULT_MSG = "resultMsg"; //처리 메세지
	
	public static String SUCCESS_MSG_001 = "정상 처리 되었습니다.";
	public static String SUCCESS_MSG_002 = "조회 되었습니다.";
	public static String SUCCESS_MSG_003 = "등록 되었습니다.";
	public static String SUCCESS_MSG_004 = "수정 되었습니다.";
	public static String SUCCESS_MSG_005 = "삭제 되었습니다.";
	
	public static String FAIL_MSG_001 = "시스템 오류가 발생하였습니다.";
	public static String FAIL_MSG_002 = "데이터베이스 오류가 발생하였습니다.";
	public static String FAIL_MSG_010 = "잘못 된 접근입니다.";
	public static String FAIL_MSG_011 = "권한이 없습니다.";

	public static String NEWS_TABLE = "NEWS";
	public static String NOTI_TABLE = "NOTI";
	public static String RANK_TABLE = "RANK";
	public static String INTR_TABLE = "INTR";
	public static String FORUM_TABLE = "FORUM";
	public static String FREE_TABLE = "FREE";
	public static String JOKE_TABLE = "JOKE";
	public static String YR_TABLE = "YR";
	public static String OPER_TABLE = "OPER";
	public static String NTFX_TABLE = "NTFX";
	
	public static String NOTI_BD_TP_CD = "01"; /* 01:공지, 02:운영, 03:뉴스 - 통합*/
	public static String OPER_BD_TP_CD = "02"; /* 01:공지, 02:운영, 03:뉴스 - 통합*/
	public static String NEWS_BD_TP_CD = "03"; /* 01:공지, 02:운영, 03:뉴스 - 통합*/
	public static String RANK_BD_TP_CD = "05"; /* 05:랭킹 */
	public static String INTR_BD_TP_CD = "06"; /* 06:홍보 */
	public static String FORUM_BD_TP_CD = "10"; /* 10:포럼 */
	public static String FREE_BD_TP_CD = "50"; /* 50:자유, 51:유머 - 통합 */
	public static String JOKE_BD_TP_CD = "51"; /* 50:자유, 51:유머 - 통합 */
	public static String YR_BD_TP_CD = "70"; /* 70:유랭 */
	public static String NTFX_BD_TP_CD = "80"; /* 80:넷플릭스랭킹 */
	
	public static String ADMIN_USR_LV = "99"; /* 99:관리자레벨*/
	
	public static Properties data = null;
	static {
		System.out.println("Properties file loadding start.....");
		Config.data = new Properties();
		InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			data.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Properties file loadding end.....");
	}
	
	//test
	public static void main(String[] args) {
		System.out.println(Config.data.get("jdbc.url"));
	}
}
