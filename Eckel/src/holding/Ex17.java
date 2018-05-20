package holding;

import java.util.HashMap;
import java.util.Iterator;

public class Ex17
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		HashMap<String, Gerbil> map = new HashMap<String, Gerbil> ();
		Gerbil g1 = new Gerbil( "Жора" );
		Gerbil g2 = new Gerbil( "Боря" );
		Gerbil g3 = new Gerbil( "Коша" );
		Gerbil g4 = new Gerbil( "Мура" );
		
		map.put( g1.getName(), g1 );
		map.put( g2.getName(), g2 );
		map.put( g3.getName(), g3 );
		map.put( g4.getName(), g4 );
		
		Iterator<String> it = map.keySet().iterator(); 
		
		while( it.hasNext() )
		{
			map.get( it.next() ).hop();
		}
	}

}
