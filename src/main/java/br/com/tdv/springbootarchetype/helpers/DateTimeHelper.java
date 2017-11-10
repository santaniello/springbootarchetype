package br.com.tdv.springbootarchetype.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeHelper {

	public static String toDateAsString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return date != null ? formatter.format(date) : "null";
	}
	
	public static String toDateAsString(Calendar calendar){
		return calendar != null ? toDateAsString(calendar) : "null";
	}
	
	
	public static String toDateTimeAsString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return date != null ? formatter.format(date) : "null";
	}
	
	public static String toDateTimeAsString(Calendar calendar){
		return calendar != null ? toDateTimeAsString(calendar.getTime()) : "null";
	}

	public static String toTimeAsString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return date != null ? formatter.format(date) : "null";
	}
	
	public static String toTimeAsString(Calendar calendar){
		return calendar != null ? toTimeAsString(calendar) : "null";
	}
	
}
