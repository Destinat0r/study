package geekbrains;

import java.util.*;

public class StringCounter
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		String str = "Во саду ли в огороде...";
		
		char[] arr = str.toLowerCase().toCharArray();
		
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		
		for( char c : arr )
		{
			if( tm.containsKey( c ) )
			{
				int temp = tm.get( c );
				tm.put( c, ++temp );
			}
			else {
				tm.put( c, 1 );
			}
		}
		
		for( char c : tm.keySet() )
		{
			for( int i = 0; i < tm.get( c ); ++i )
			{
				System.out.print( c );
			}
		}
		
		
//		for (Map.Entry<Character, Integer> entry : tm.entrySet()) {
//		     System.out.println("|| " + entry.getKey() + " -- " + entry.getValue());
//		}
		
//		System.out.println( tm );
	}

}
