package holding;

import java.util.*;

public class App
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		//comment
		List<String> lst = new ArrayList<String>();
		
		lst.add("Good");
		lst.add("Bad");
		lst.add("Evil");
		lst.add("Dead");
		
		lst = new LinkedList<String>();
		
		lst.add("Nice");
		lst.add("Nice");
		lst.add("Nice");
		
		for( String string : lst )
		{
			System.out.println( string );
		};
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static int[] sort( int[] m )
	{
		
		int i = 0;
		int rightPairs = 0;
		while( true )
		{
			if( i == m.length - 1 )
			{
				i = 0;
			}
			if( m[ i ] > m[ i + 1 ] )
			{
				int t = m[ i ];
				m[ i ] = m[ i + 1 ];
				m[ i + 1 ] = t;
				rightPairs = 0;
			}
			else
			{
				rightPairs++;
			}
			i++;
			if( rightPairs == m.length )
				break;

		}
		
		return m;
	}

}
