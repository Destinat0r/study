package utils;

import java.io.PrintStream;

public class Print
{
	public static void print( Object s )
	{
		System.out.println( s );
	}
	
	public static void printnb( Object s )
	{
		System.out.print( s );
	}
	
	public static void print()
	{
		System.out.println();
	}
	
	public static PrintStream printf( String format, Object... args )
	{
		return System.out.printf( format, args );
	}
}
