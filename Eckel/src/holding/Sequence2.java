package holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sequence2
{
	private List<Object> items;
	
	// -----------------------------------------------------------------------------------------------------------------
	public Sequence2()
	{
		items = new ArrayList<Object>();
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void add( Object x )
	{
		items.add( x );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public Iterator<Object> getIter()
	{
		return items.iterator();
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Sequence2 seq = new Sequence2();
		for( int i = 0; i < 10; i++ )
		{
			seq.add( new Double(i) );
		}
		
		for( Iterator<Object> iter = seq.getIter(); iter.hasNext(); System.out.println( " Number " + iter.next() )  );
//		while( iter.hasNext() )
//		{
//			Object o = iter.next();
//			System.out.println( " Number " + o );
//		}
	}

}
