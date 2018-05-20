package interfaces;

import static utils.Print.*;

public class Ride
{
	public static void rideBike( CycleFactory factory )
	{
		Cycle bike = factory.getCycle();
		bike.ride();
	}
	
	public static void main( String[] args )
	{
		rideBike( new BicycleFactory() );
		rideBike( new TricycleFactory() );
		rideBike( new UnicycleFactory() );
	}
}

interface Cycle
{
	void ride();
}

interface CycleFactory
{
	Cycle getCycle();
}

class Bicycle implements Cycle
{
	public void ride()
	{
		print( "Bicycle riding" );
	}
}

class BicycleFactory implements CycleFactory
{
	public Cycle getCycle()
	{
		return new Bicycle();
	}
}

class Tricycle implements Cycle
{
	public void ride()
	{
		print( "Tricycle riding" );
	}
}

class TricycleFactory implements CycleFactory
{
	public Cycle getCycle()
	{
		return new Tricycle();
	}
}

class Unicycle implements Cycle
{
	public void ride()
	{
		print( "Unicycle riding" );
	}
}

class UnicycleFactory implements CycleFactory
{
	public Cycle getCycle()
	{
		return new Unicycle();
	}
}
