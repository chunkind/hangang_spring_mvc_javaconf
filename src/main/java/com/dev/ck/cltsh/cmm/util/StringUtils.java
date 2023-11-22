package com.dev.ck.cltsh.cmm.util;

public class StringUtils {
	private static String emptyStr = "";
	
	public static String nullToStr(String text){
		String result = text;
		if(null == text || "null".equals(text) || "".equals(text)){
			result = "";
		}
		return result;
	}

	public static int nullToInt(String text){
		int result = 0;
		if(null == text || "null".equals(text) || "".equals(text)){
			result = 0;
		}else{
			result = Integer.parseInt(text);
		}
		return result;
	}

	public static long nullToLong(String text){
		long result = 0;
		if(null == text || "null".equals(text) || "".equals(text)){
			result = 0L;
		}else{
			result = Long.parseLong(text);
		}
		return result;
	}
	
	public static String leftPad(final String pData, final int length, final char fillChar) throws RuntimeException {
		return padString(pData,1,length, fillChar);
	}
	
	private static String padString(final String data, final int align, final int fillSize, final char fillChar) throws RuntimeException {
		StringBuffer rtnBuf;
		byte[] bytes;
		String result;
		
		try {
			result = (data == null ? emptyStr : data);
			rtnBuf = new StringBuffer();
			
			bytes = result.trim().getBytes("EUC-KR");
			final int len = bytes.length;
	
			// 모자라는 길이만큼 채울 문자열을 만든다.
			if (len < fillSize)  {   
				if (align == 0) {
					rtnBuf.append(result);
					for (int i = len; i < fillSize; i++) { rtnBuf.append(fillChar); }
					
				} else {
					for (int i = len; i < fillSize; i++) { rtnBuf.append(fillChar); }
					rtnBuf.append(result);
				}
				
			// 원하는 길이보다 크면 잘라 보낸다.
			} else {	
				if (align == 0) { rtnBuf.append(new String(bytes, 0, fillSize)); }
				else { rtnBuf.append(new String(bytes, len - fillSize, fillSize)); }
			}
			result = rtnBuf.toString();
			return result;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}
