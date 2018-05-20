package shape;
import static utils.Print.*;

import java.util.Random;

class Instrument
{
	void play( Note n )
	{
		print( "Instrument.play() " + n );
	}

	public String toString()
	{
		return "Instrument";
	}

	void adjust()
	{
		print( "Adjusting Instrument" );
	}
}

class Wind extends Instrument
{
	void play( Note n )
	{
		print( "Wind.play() " + n );
	}

	public String toString()
	{
		return "Wind";
	}

	void adjust()
	{
		print( "Adjusting Wind" );
	}
}

class Percussion extends Instrument
{
	void play( Note n )
	{
		print( "Percussion.play() " + n );
	}

	public String toString()
	{
		return "Percussion";
	}

	void adjust()
	{
		print( "Adjusting Percussion" );
	}
}

class Stringed extends Instrument
{
	void play( Note n )
	{
		print( "Stringed.play() " + n );
	}

	public String toString()
	{
		return "Stringed";
	}

	void adjust()
	{
		print( "Adjusting Stringed" );
	}
}

class Guitar extends Stringed
{
	void play( Note n )
	{
		print( "Guitar.play() " + n );
	}
	
	void adjust()
	{
		print( "Adjusting Guitar" );
	}
	
	public String toString()
	{
		return "Guitar";
	}
}

class Brass extends Wind
{
	void play( Note n )
	{
		print( "Brass.play() " + n );
	}

	void adjust()
	{
		print( "Adjusting Brass" );
	}
}

class Woodwind extends Wind
{
	void play( Note n )
	{
		print( "Woodwind.play() " + n );
	}

	public String toString()
	{
		return "Woodwind";
	}
}

public class Music3
{
	// Doesn't care about type, so new types
	// added to the system still work right:
	public static void tune( Instrument i )
	{
		// ...
		i.play( Note.MIDDLE_C );
	}

	public static void tuneAll( Instrument[] e )
	{
		for( Instrument i : e )
			print( i );
	}

	public static void main( String[] args )
	{		
		// Upcasting during addition to the array:
		Instrument[] orchestra = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind(), new Guitar()  };
		tuneAll( orchestra );
		
		Random rand = new Random();
		
		for( int i = 0; i < 6; i++ )
		{
			int instrumentToPrint = rand.nextInt(6);
			Instrument inst = null;
			switch( instrumentToPrint )
			{
				case 0:
					inst = new Wind();
					break;
				case 1:
					inst = new Percussion();
					break;
				case 2:
					inst = new Stringed();
					break;
				case 3:
					inst = new Brass();
					break;
				case 4:
					inst = new Woodwind();
					break;
				case 5:
					inst = new Guitar();
					break;
			}
			print( inst );
		}
	}
} 