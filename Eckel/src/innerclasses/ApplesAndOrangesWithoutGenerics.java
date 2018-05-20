package innerclasses;

import java.util.*;

class Apple
{
	private static long counter;
	private final long id = counter++;

	public long id()
	{
		return id;
	}
}

class Orange
{
}

public class ApplesAndOrangesWithoutGenerics
{
	public static void main( String[] args )
	{
		ArrayList<Apple> apples = new ArrayList<Apple>();
		for( int i = 0; i < 3; i++ )
			apples.add( new Apple() );
		// Not prevented from adding an Orange to apples:
		for( int i = 0; i < apples.size(); i++ )
			((Apple)apples.get( i )).id();
		// Orange is detected only at run time
	}
}