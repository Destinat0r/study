package geekbrains;

import java.util.*;

public class LetterCount implements Comparator<Object>
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		int[] arr = { 3, 2, 1, 2, 3, 2, 1, 5, 6, 7 };
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>( new ReverseComparator() );
		
		for( int val : arr )
		{
			Integer integer = map.get( val );
			if( integer == null )
			{
				map.put( val, 1 );
			}
			else 
			{
				map.put( val, integer + 1 );
			}
		}
		
		
		for( int val : map.keySet() )
		{
			for( int i = 0; i < map.get( val ); ++i )
			{
				System.out.print( val );
			}
		}
		
//		Collections.sort( map, c );
//		System.out.println( map );
		
	}

	@Override
	public int compare( Object o1, Object o2 )
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
