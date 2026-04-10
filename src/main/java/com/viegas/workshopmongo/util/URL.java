package com.viegas.workshopmongo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class URL {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDate convertDate (String textDate, LocalDate defaultValue) {
		
		if (textDate == null || textDate.isBlank()) {
	        return defaultValue;
	    }

	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    try {
	        return LocalDate.parse(textDate, dtf);
	    } catch (Exception e) {
	        return defaultValue;
	    }
	}

}
