package polymorph;

import static utils.Print.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Rodents
{
	public static void main( String[] args )
	{
		ArrayList<Rodent> rodents = new ArrayList<Rodent>();
		
		rodents.add( new Mouse() );
		rodents.add( new Hamster() );
		rodents.add( new Mouse() );
		
		Iterator<Rodent> iter = rodents.iterator();
		while( iter.hasNext() )
		{
			Rodent rod = iter.next();
			rod.gnaw();
		}
		
	}
}

interface Rodent
{
	Food f1 = new Food();

	public void gnaw();
	

	public void digHole();
	
	
	public void dispose();
}

class Mouse implements Rodent
{
	Mouse()
	{
		print( "Mouse constructor" );
	}

	public void peep()
	{
		print( "Mouse peeps" );
	}
	
	@Override
	public void gnaw()
	{
		print( "Mouse gnaws" );
	}

	@Override
	public void digHole()
	{
		print( "Mouse is digging a hole" );
	}

	@Override
	public void dispose()
	{
		print( "mouse dispose()" );
		
	}
}

class Hamster implements Rodent
{
	Hamster()
	{
		print( "Hamster constructor" );
	}

	public void peep()
	{
		print( "Hamster peeps" );
	}
	
	@Override
	public void gnaw()
	{
		print( "Hamster gnaws" );
	}

	@Override
	public void digHole()
	{
		print( "Hamster is digging a hole" );
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}
}

class Food
{
	public static long count = 0;

	Food()
	{
		print( "Food created!" );
		count++;
	}

	public void dispose()
	{
		if( --count == 0 )
			print( "Food disposed" );
	}
}