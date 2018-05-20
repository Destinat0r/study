package holding;

import java.util.*;

public class Main
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		List<String> staff = new LinkedList<String>();
		staff.add( "Amy" );
		staff.add( "Валя" );
		staff.add( "Яна" );
		
		
		ListIterator<String> iter = staff.listIterator();
		iter.next();
		iter.next();
		iter.add("Маша");
		
		iter.add("Света");
		iter.add("Ира");
		iter.add("Лада");
		
		for( String string : staff )
		{
			System.out.println( string );
		}
	}

}
