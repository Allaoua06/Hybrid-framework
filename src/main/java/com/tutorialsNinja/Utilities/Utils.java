package com.tutorialsNinja.Utilities;

import java.util.Date;

public class Utils {
	
	public static final int IMPLICIT_WAIT = 10;
	public static final int PAGE_LOAD_TIMEOUT = 10;
	public static final int SCRIPT_TIMEOUT = 1000;
	
	public static void main(String[] args) {
		emailWithDateTimeStamp();
	}
	
	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		
		System.out.println(date); 
		String emailTimeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + emailTimeStamp + "@gmail.com";
	}

}
