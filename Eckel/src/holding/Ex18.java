package holding;

import java.util.HashMap;
import java.util.Random;

public class Ex18
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Random rand = new Random();
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for( int i = 0; i < 6; ++i )
		{
			int key = rand.nextInt(100);
			String value = "";
			
			for( int j = 0; j < 10; ++j )
			{
				value += Character.toChars( rand.nextInt(500) );
			}
			
			map.put( key, value );
		}
		
		System.out.println( map );
	}

}
