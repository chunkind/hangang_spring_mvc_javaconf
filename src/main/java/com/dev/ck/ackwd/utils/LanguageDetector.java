package com.dev.ck.ackwd.utils;

public class LanguageDetector {
	public static void main(String[] args) {
		System.out.println(isEnglish("ㄸ"));
		System.out.println(isEnglish("d"));
		System.out.println(hasKorean("D"));
		System.out.println(hasKorean("ㅇ"));
		System.out.println(hasKorean("ejfjwiefjawo안녕!!"));
		System.out.println(hasKorean("fajwioejfowaejfo!!"));
		System.out.println(hasKorean("뮆!!"));
		System.out.println(hasKorean("!!뮆!!"));
	}
	public enum Language {Korean, Japanese, English}

	public static boolean isEnglish(CharSequence charSequence) {
		boolean isEnglish = true;
		for (char c : charSequence.toString().toCharArray()) {
			if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN) {
				isEnglish = false;
				break;
			}
		}
		return isEnglish;
	}

	public static boolean hasKorean(CharSequence charSequence) {
		boolean hasKorean = false;
		for (char c : charSequence.toString().toCharArray()) {
			if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_JAMO
					|| Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO
					|| Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_SYLLABLES) {
				hasKorean = true;
				break;
			}
		}
		return hasKorean;
	}

	public static boolean hasJapanese(CharSequence charSequence) {
		boolean hasJapanese = false;
		for (char c : charSequence.toString().toCharArray()) {
			if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HIRAGANA
					|| Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KATAKANA
					|| Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
					|| Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
					|| Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
				hasJapanese = true;
				break;
			}
		}
		return hasJapanese;
	}
}