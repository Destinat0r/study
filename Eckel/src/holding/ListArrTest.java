package holding;

import java.util.*;

public class ListArrTest
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		List<Fighter> list = new ArrayList<Fighter>( Arrays.asList( new Fighter(), new Fighter(), new Fighter(), 
				new Fighter(), new Fighter() ) );
		
		System.out.println( list );
		
		List<Fighter> sub = list.subList(1, 3);
		
		list.removeAll( sub );
		
		System.out.println( list );
	}

}

class Fighter
{
	
}