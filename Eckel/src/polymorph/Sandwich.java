package polymorph;

import static utils.Print.*;

class Meal
{
	Meal()
	{
		print( "Meal()" );
	}
}

class Bread
{
	Bread()
	{
		print( "Bread()" );
	}
}

class Cheese
{
	Cheese()
	{
		print( "Cheese()" );
	}
}

class Lettuce
{
	Lettuce()
	{
		print( "Lettuce()" );
	}
}

class Pickle
{
	Pickle()
	{
		print( "Pickle()" );
	}
}

class Lunch extends Meal
{
	Lunch()
	{
		print( "Lunch()" );
	}
}

class PortableLunch extends Lunch
{
	PortableLunch()
	{
		print( "PortableLunch()" );
	}
}

interface FastFood
{
	void junk();
	void garbage();
	void shit();
}

public class Sandwich extends PortableLunch implements FastFood
{

	public Sandwich()
	{
		print( "Sandwich()" );
	}

	public static void main( String[] args )
	{
		new Sandwich();
	}

	@Override
	public void junk()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void garbage()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shit()
	{
		// TODO Auto-generated method stub
		
	}
}
