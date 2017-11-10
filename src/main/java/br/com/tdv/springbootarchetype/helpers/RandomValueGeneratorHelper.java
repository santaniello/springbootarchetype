package br.com.tdv.springbootarchetype.helpers;

import java.util.Random;

public class RandomValueGeneratorHelper {

	private static final String POSSIBLE_LETTERS = "abcdefghijklmnopqrstuvywxzABCDEFGHIJKLMNOPQRSTUVYWXZ"; 
	private static final int DEFAULT_RANGE = POSSIBLE_LETTERS.length();
	
	public static String anyString() {
		String any = anyString(DEFAULT_RANGE);
		return any;
	}

	public static String anyString(int range) {
		Random random = new Random();  
		String dataGenerated = "";  
		int index = -1;  
		for( int i = 0; i < POSSIBLE_LETTERS.length(); i++ ) {  
		   index = random.nextInt( POSSIBLE_LETTERS.length() );  
		   dataGenerated += POSSIBLE_LETTERS.substring( index, index + 1 );  
		}  
		
		String finalStr = dataGenerated.length() > range ? dataGenerated.substring(0, range) : dataGenerated;
		while( finalStr.length() < range ){
			for( int i = 0; i < POSSIBLE_LETTERS.length(); i++ ) {  
				   index = random.nextInt( POSSIBLE_LETTERS.length() );  
				   dataGenerated += POSSIBLE_LETTERS.substring( index, index + 1 );  
			}  
			finalStr += dataGenerated;
		}
		return finalStr;
	}
	
	public static String anyString(String prefixo) {
		return prefixo + anyString();
	}
	
	public static String anyString(String prefixo, int range) {
		String str = prefixo + anyString();
		str = anyString(range);
		return str;
	}

	public static int anyInteger(){
		int maxLength = String.valueOf( Integer.MAX_VALUE ).length();
		int any = Integer.parseInt( String.valueOf( Math.random() ).replace(".", "").substring(0, maxLength) );
		return any;
	}

	public static String anyIntegerStr(){
		int maxLength = String.valueOf( Integer.MAX_VALUE ).length();
		int any = Integer.parseInt( String.valueOf( Math.random() ).replace(".", "").substring(0, maxLength) );
		return String.valueOf( any );
	}
	
	public static double anyDouble(){
		double any = Math.random();
		return any;
	}
	
	public static Long anyLong(){
		Long any =  (long) Math.random();
		return any;
	}
	
	public static void main(String[] args) {
		
		System.out.println( RandomValueGeneratorHelper.anyString() );
		System.out.println( RandomValueGeneratorHelper.anyString( 50 ) );
		System.out.println( RandomValueGeneratorHelper.anyString( "nome", 30 ) );
		
		System.out.println( "---" );
		
		System.out.println( anyInteger() );
		
	}
}
