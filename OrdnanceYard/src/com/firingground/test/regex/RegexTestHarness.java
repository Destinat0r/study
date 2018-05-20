package com.firingground.test.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness
{

	public static void main( String[] args )
	{
		Pattern patern = Pattern.compile( "(?<=Host: ).+(?=\r\n)" );
		Matcher match = patern.matcher( "GET /posts HTTP/1.0\r\nHost: jsonplaceholder.typicode.com\r\n" );
		
		String result = "";
		if( match.find() ){
			result = match.group();
		}
		System.out.println( result );
		 
	}
}