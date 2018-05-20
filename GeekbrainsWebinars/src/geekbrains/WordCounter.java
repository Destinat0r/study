package geekbrains;

import java.util.*;

public class WordCounter
{	
	private TreeMap<String, Integer> tm;
	
	WordCounter( String str )
	{
		tm = new TreeMap<String, Integer>();
		String[] arr = str.toLowerCase().split(" ");
		
		for( int i = 0; i < arr.length; ++i )
		{
			if( !tm.containsKey( arr[ i ] ) )
			{
				tm.put( arr[ i ], 1 );
			}
			else
			{
				int temp = tm.get( arr[ i ] );
				tm.put( arr[ i ], ++temp );
			}
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		String str = "–аз два раз два три четыре четыре раз два";
		
		WordCounter wc = new WordCounter( str );
		
		System.out.println( wc.tm );
	}
	
	public void sort()
	{
		
	}
	

}
