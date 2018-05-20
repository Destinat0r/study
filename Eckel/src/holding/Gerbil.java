package holding;

import java.util.*;

public class Gerbil
{
	@SuppressWarnings("unused")
	private int gerbilNumber;
	private String name;
	
	// -----------------------------------------------------------------------------------------------------------------
	Gerbil( int num )
	{
		this.gerbilNumber = num;
	}
	
	Gerbil( String name )
	{
		this.setName( name );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void hop()
	{
		System.out.println( "Short message + name:" + name );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		ArrayList<Gerbil> gbls = new ArrayList<Gerbil>();
		
		for( int i = 0; i < 5; i++ )
		{
			gbls.add( new Gerbil( i ) );
		}
		
		Iterator<Gerbil> it = gbls.iterator(); 
		
		while( it.hasNext() )
		{
			Gerbil gb = it.next();
			
			gb.hop();
		}
		
//		for( Gerbil g : gbls )
//		{
//			g.hop();
//		}
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

}
