package com.softserve.edu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {

	private final static String NUMBER_IN_BRACKETS = ""; // create regex
	private final static String NUMBER_BEFORE_BRACKETS = ""; // create regex
	private final static String EXTRACT_NUMBER_MESSAGE = "NumberFormatException for pattern =  %s text =  %s";

	private RegexUtils() {
	}

	public static String extractFirstString(String pattern, String text) {
		String result = "";
		Matcher matcher = Pattern.compile(pattern).matcher(text);
		if (matcher.find()) {
			result = text.substring(matcher.start(), matcher.end());
		}
		return result;
	}

	public static int extractNumberFromBrackets(String text) {
		int result = -1;
		// To Do
		
		return result;
	}

	public static int extractNumberBeforeBrackets(String text) {
		int result = -1;
		// To Do
		
		return result;
	}
}
