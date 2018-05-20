package geekbrains;

import java.util.*;

public class BubbleSort
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Random rand = new Random();
		int[] arr = new int[20];
		
		for( int i = 0; i < arr.length; ++i )
		{
			arr[ i ] = rand.nextInt( 100 );
		}
		
		System.out.println( Arrays.toString( arr ) );
		
		for( int i = 0; i < arr.length; ++i )
		{
			for( int j = 0; j < arr.length - 1; ++j )
			{
				if(  arr[ j ] > arr [ j + 1 ] )
				{
					int temp = arr[ j ];
					arr[ j ] = arr[ j + 1 ];
					arr[ j + 1 ] = temp;
				}
			}
		}
		
		System.out.println( Arrays.toString( arr ) );
	}

}
