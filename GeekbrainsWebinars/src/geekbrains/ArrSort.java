package geekbrains;

import java.util.*;
import java.util.Random;

public class ArrSort
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Random rand = new Random();
		
		int[] arr = new int[20];

		for( int i = 0; i < arr.length; i++ )
		{
			arr[ i ] = rand.nextInt( 10 );
		}
		
		System.out.println(Arrays.toString( arr ) );
		
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		
		for( int j = 0; j < arr.length; ++j )
		{
			if( !tm.containsKey( arr[ j ] ) )
			{
				tm.put( arr[ j ], 1 );
			}
			else
			{
				int temp = tm.get( arr[ j ] );
				tm.put(  arr[ j ] , ++temp );
			}
		}
		
		System.out.println( tm );
	}

}
