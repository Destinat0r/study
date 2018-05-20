package collections;
	
import java.util.*;

public class MoviesChars
{	
	private static int count = 0;

	// -----------------------------------------------------------------------------------------------------------------
	public static String next()
	{
		
		 String[] chars = new String[]{ "Terminator", "Ripley", "Marty McFly", "Ip man", };
		 if( count >= chars.length )
		 {
			 count = 0;
		 }
		 return chars[ count++ ];
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		ArrayList<String> arrl = new ArrayList<String>();
		LinkedList<String> linkl = new LinkedList<String>();
		HashSet<String> hashs = new HashSet<String>();
		LinkedHashSet<String> linkhs = new LinkedHashSet<String>();
		TreeSet<String> trSet = new TreeSet<String>();
		
		fill( arrl, 10 );
		fill( linkl, 10 );
		fill( hashs, 10 );
		fill( linkhs, 10 );
		fill( trSet, 10 );
		
		display( arrl );
		display( linkl );
		display( hashs );
		display( linkhs );
		display( trSet );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void fill( Collection<String> col, int howMuch )
	{
		int count = 0;
		while( count < howMuch )
		{
			col.add( next() );
			count++;
		}
	}
	
	public static void display( Collection<String> col )
	{
		System.out.println( col );
	}

}
