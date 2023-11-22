package ckframework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * DateFormat
 * 문자	날짜 및 시간 요소 										표시					예제
 * G	Era designator										Text				AD
 * y	Year												Year				1996; 96
 * Y	Week year											Year				2009; 09
 * M	Month in year (context sensitive)					Month				July; Jul; 07
 * L	Month in year (standalone form)						Month				July; Jul; 07
 * w	Week in year										Number				27
 * W	Week in month										Number				2
 * D	Day in year											Number				189
 * d	Day in month										Number				10
 * F	Day of week in month								Number				2
 * E	Day name in week									Text				Tuesday; Tue
 * u	Day number of week (1 = Monday, ..., 7 = Sunday)	Number				1
 * a	Am/pm marker										Text				PM
 * H	Hour in day (0-23)									Number				0
 * k	Hour in day (1-24)									Number				24
 * K	Hour in am/pm (0-11)								Number				0
 * h	Hour in am/pm (1-12)								Number				12
 * m	Minute in hour										Number				30
 * s	Second in minute									Number				55
 * S	Millisecond											Number				978
 * z	Time zone											General time zone	Pacific Standard Time; PST; GMT-08:00
 * Z	Time zone											RFC 822 time zone	-0800
 * X	Time zone											ISO 8601 time zone	-08; -0800; -08:00
 */
public class DateUtil {
	public final static long ONE_MIN 	= 1000 * 60;
	public final static long ONE_HOUR 	= 1000 * 60 * 60;
	public final static long ONE_DAY 	= 1000 * 60 * 60 * 24;
	
	public final static String FORMAT01 = "yyyy-MM-dd";
	public final static String FORMAT02 = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT03 = "yyyyMMddHHmmss";
	public final static String FORMAT04 = "yyyy.MM.dd G 'at' HH:mm:ss z"; /*2001.07.04 AD at 12:08:56 PDT*/
	public final static String FORMAT05 = "EEE, MMM d, ''yy"; /*Wed, Jul 4, '01*/
	public final static String FORMAT06 = "h:mm a"; /*12:08 PM*/
	public final static String FORMAT07 = "hh 'o''clock' a, zzzz"; /*12 o'clock PM, Pacific Daylight Time*/
	public final static String FORMAT08 = "K:mm a, z"; /*0:08 PM, PDT*/
	public final static String FORMAT09 = "yyyyy.MMMMM.dd GGG hh:mm aaa"; /*02001.July.04 AD 12:08 PM*/
	public final static String FORMAT10 = "EEE, d MMM yyyy HH:mm:ss Z"; /*Wed, 4 Jul 2001 12:08:56 -0700*/
	public final static String FORMAT11 = "yyyyMMddHHmmssZ"; /*20010704120856-0700*/
	public final static String FORMAT12 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; /*2001-07-04T12:08:56.235-0700*/
	public final static String FORMAT13 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"; /*2001-07-04T12:08:56.235-07:00*/
	public final static String FORMAT14 = "YYYY-'W'ww-u"; /*2001-W27-3*/
	
	public static final String FORMAT15 = "yyyyMMdd";
	public static final String FORMAT16 = "yyyy-MM-dd";

	/**
	 * @Auth: K. J. S.
	 * @Date: 2023. 07. 26.
	 * 현재 날짜 문자열로 가져 오기
	 */
	public static String getStrDate() {
		return DateUtil.getStrDate(new java.util.Date(), FORMAT01);
	}
	public static String getStrDate(String format) {
		return DateUtil.getStrDate(new java.util.Date(), format);
	}
	public static String getStrDate(java.util.Date date) {
		return DateUtil.getStrDate(date, FORMAT01);
	}
	public static String getStrDate(java.sql.Date date) {
		return DateUtil.getStrDate(date, FORMAT01);
	}
	public static String getStrDate(java.util.Date date, String format) {
		java.util.Date today = date;
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(today);
	}
	
	/**
	 * @Auth: K. J. S.
	 * @Date: 2023. 07. 26.
	 * 현재 날짜와 시간 문자열로 가져 오기
	 */
	public static String getStrDateTime(){
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat(FORMAT02);
		return format.format(today);
	}
	
	public static Date getDate(String date){
		return DateUtil.getDate(date, FORMAT01);
	}

	public static Date getDate(String date, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
//		String ss = sdf.format(new java.util.Date());
		String ss = sdf.format(new java.util.Date());
		java.sql.Date d = java.sql.Date.valueOf(ss);
		return d;
	}
	

	public static void main(String[] args) {
		DateUtil du = new DateUtil();
		//오늘날짜
		System.out.println(DateUtil.toDay(FORMAT16));
		System.out.println(du.toDay());
//		System.out.println(du.toDayTypeDate());
		//날짜 더하기
//		System.out.println(du.addDate("20170101",DAFAULT_DATE_FORMAT, 0, 0, 0));
//		System.out.println(du.addDate(1, 0, 0));

		//스트링 문자로된 날짜 비교
		//정상값
//		System.out.println(du.compareDate("20181201231201", "20181201231202", "yyyyMMddkkmmss"));
		//자리수 불일치.
//		System.out.println(du.compareDate("2018120123120", "20181201231202", "yyyyMMddkkmmss"));

		System.out.println(du.toDayTypeDate());
	}

	public static String getLastDayOfMonth(){
		String stdToday = DateUtil.toDay(DateUtil.FORMAT16);
		String[] splitDate = stdToday.split("-");



		Calendar cal = Calendar.getInstance();
		String result = "";
		Date today = DateUtil.toDayTypeDate();
		cal.setTime(today);

		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//		result = today.getYear()
		if(lastDay < 10){

		}
		return "";
	}

	/**
	 * @auth : K. J. S.
	 * @date : 2018. 12. 2.
	 * 스트링 문자 2개를 받아 비교.
	 */
	public static int compareDate(String date1, String date2, String format) {
		Date target1 = null;
		Date target2 = null;
		int compare = 0;
		SimpleDateFormat mSimpleDateFormat = null;
		try {
			if(date1.length() != date2.length()) {
				throw new RuntimeException("두 날짜간 형식이 맞지 않습니다.");
			}
			mSimpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);

			target1 = mSimpleDateFormat.parse(date1);
			target2 = mSimpleDateFormat.parse(date2);
			compare = target1.compareTo(target2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return compare;
	}
	public static int compareDate(Date date1, Date date2) {
		return date1.compareTo(date2);
	}

	/**
	 * @auth : K. J. S.
	 * @date : 2018. 12. 2.
	 * Date 타입을 String으로 변환.
	 */
	public static String dateToStr(Date date) {
		return DateUtil.dateToStr(date, "");
	}
	public static String dateToStr(Date date, String format) {
		if("".equals(format)) format = FORMAT15;
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * @Auth K. J. S.
	 * @date 2018. 11. 28.
	 * 오늘 날짜 구하기.
	 */
	public static String toDay(){
		return DateUtil.toDay("");
	}
	public static String toDay(String format){
		if("".equals(format)) format = FORMAT15;
		DateFormat df = new SimpleDateFormat(format);
		return df.format(DateUtil.toDayTypeDate(format));
	}
	public static Date toDayTypeDate(){
		return DateUtil.toDayTypeDate("");
	}
	public static Date toDayTypeDate(String format){
		if("".equals(format)) format = FORMAT15;
		DateFormat df = new SimpleDateFormat(format);
		Date date = null;
		Calendar cal = null;
		try {
			date = df.parse(df.format(new Date()));
			cal = Calendar.getInstance();
			cal.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.getTime();
	}

	/**
	 * @Auth K. J. S.
	 * @date 2018. 11. 28.
	 * targetDate 기준일에 날짜 더하기
	 * targetDate가 널이면 오늘 날짜를 기준.
	 * format이 널이면 yyyyMMdd가 기본.
	 */
	public static String addDate(int addYear, int addMonth, int addDate){
		String format = FORMAT15;
		return DateUtil.addDate(toDay(format), format, addYear, addMonth, addDate);
	}
	public static String addDate(String format, int addYear, int addMonth, int addDate){
		return DateUtil.addDate(toDay(format), format, addYear, addMonth, addDate);
	}
	public static String addDate(String targetDate, String format, int addYear, int addMonth, int addDate){
		DateFormat df = new SimpleDateFormat(format);
		Date date = null;
		Calendar cal = null;
		try {
			if("".equals(targetDate)){
				date = df.parse(df.format(new Date()));
			}else{
				date = df.parse(targetDate);
			}
			cal = Calendar.getInstance();
			cal.setTime(date);

			if(addDate > 0){
				cal.add(Calendar.DATE, addDate);
			}
			if(addMonth > 0){
				cal.add(Calendar.MONTH, addMonth);
			}
			if(addYear > 0){
				cal.add(Calendar.YEAR, addYear);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df.format(cal.getTime());
	}

	/**
	 * @auth : K. J. S.
	 * @date : 2018. 12. 2.
	 * Date 객체를 리턴.
	 */
	public static Date date(String date) {
		return DateUtil.date(date, "");
	}
	public static Date date(String date, String format) {
		if("".equals(format)) format = FORMAT15;
		DateFormat df = new SimpleDateFormat(format);
		Calendar cal = null;
		try {
			cal = Calendar.getInstance();
			cal.setTime(df.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.getTime();
	}
}
