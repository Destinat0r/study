package innerclasses;

import java.util.*;

interface Selector
{
	boolean end();

	Object current();

	void next();
}

public class Sequence
{
	private List<Object> items;

	public Sequence( int size )
	{
		items = new ArrayList<Object>();
	}

	public List<Object> getItems()
	{
		return this.items;
	}
	
	public void add( Object x )
	{
		items.add( x );
	}

	

	public Selector selector()
	{
		return new ReverseSelector();
	}
	
	

	private class ReverseSelector implements Selector
	{
	private int i = items.size() - 1;
		
		// -----------------------------------------------------------------------------------------------------------------
		public boolean end()
		{
			return i == 0;
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public Object current()
		{
			return items.get( i );
		}

		// -----------------------------------------------------------------------------------------------------------------
		public void next()
		{
			if( i != 0 )
				i--;
		}
			
	}
	
	public static void main( String[] args )
	{
		Sequence sequence = new Sequence( 10 );
		for( int i = 0; i < 10; i++ )
			sequence.add( Integer.toString( i ) );
		
		Iterator<Object> it = sequence.getItems().iterator();
		while( it.hasNext() )
		{
			Object s = it.next();
			System.out.print( s + " " );
//			selector.next();
		}
	}
}