package holding;

import java.util.*;

public class App2
{
	private String name;
	
	App2( String name )
	{
		this.name = name;
	}
	
	public String toString()
	{
		return "Object's name is " + this.name;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public static void main( String[] args )
	{
		ArrayList<App2> arrl = new ArrayList<App2>( Arrays.asList( new App2( "Bogret" ), new App2( "Seldon" ), new App2( "Mad Max" ) ) );
		LinkedList<App2> linkl = new LinkedList<App2>( Arrays.asList( new App2( "Margaret" ), new App2( "Zeus" ), new App2( "Posseidon" ) ) );
		
		List[] list = new List[]{ arrl, linkl };
		
		for( List l : list )
		{
			for( @SuppressWarnings("unchecked")
			Iterator<App2> iter = l.iterator(); iter.hasNext(); )
				System.out.println( iter.next().toString() ); 
		}
		
	}

}
