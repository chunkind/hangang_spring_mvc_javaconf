package com.dev.ck.cltsh.cmm.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflecttionUtils {
	
	public static String getType(Class clazz, String name) {
		String result = "";
		
		List<Field> list = getAllFields(clazz);
		
		for(Field obj: list) {
			if(name.equals(obj.getName())) {
				result = obj.getGenericType().getTypeName();
				break;
			}
		}
		
		return result;
	}

	public static List<Field> getAllFields(Class clazz) {
	    List<Field> fields = new ArrayList<Field>();

	    fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

	    Class superClazz = clazz.getSuperclass();
	    if(superClazz != null){
	        fields.addAll( getAllFields(superClazz) );
	    }

	    return fields;
	}
	
	public static String camelToUpperSnakeCase(String text) {
		String result = "";
		char[] textlist = text.toCharArray();
		
		for(int i=0; i<textlist.length; i++) {
			if(Character.isUpperCase(textlist[i])) {
				result += "_" + String.valueOf(textlist[i]).toUpperCase();
			} else {
				result += String.valueOf(textlist[i]).toUpperCase();
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
//		List<Field> list = ReflecttionUtils.getAllFields(EntrVO.class);
//		for(Field obj : list) {
//			System.out.println(obj.getName());
//		}
		
	}
}
