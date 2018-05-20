package geekbrains;

import java.util.*;

public class SimpleNums
{
	private ArrayList<Integer> simpleNums = new ArrayList<Integer>( Arrays.asList() );

	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		SimpleNums sn = new SimpleNums();
		sn.getAllSimpleTo( 200 );

		System.out.println( sn.simpleNums );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void getAllSimpleTo( int n )
	{
		outer: for( int i = 1; i <= n; ++i )
		{
			int divisers = 0;
			for( int num : simpleNums )
			{
				if( i % num == 0 )
					++divisers;
				if( divisers > 1 )
					continue outer;
			}
			simpleNums.add( i );
		}
	
		simpleNums.remove( Integer.valueOf( 1 ) );
	}
}
