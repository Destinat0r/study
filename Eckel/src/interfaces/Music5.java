package interfaces;

import polymorph.Note;
import static utils.Print.*;

interface Instrument
{
	// Compile-time constant:
	int VALUE = 5; // static & final
	// Cannot have method definitions:

	 // Automatically public

	void adjust();
}

interface Playable
{
	void play( Note n );
}

abstract class Instruments
{
	public void play( Note n )
	{
		print( this + ".play() " + n );
	}
	
	public abstract String toString();
	
	public void adjust()
	{
		print( this + ".adjust()" );
	};
	
}

class Wind extends Instruments implements Instrument, Playable 
{
	public String toString()
	{
		return "Wind";
	}

}

class Percussion extends Instruments implements Instrument, Playable 
{
	public String toString()
	{
		return "Percussion";
	}
}

class Stringed extends Instruments implements Instrument, Playable 
{
	public String toString()
	{
		return "Stringed";
	}
}

class Brass extends Wind
{
	public String toString()
	{
		return "Brass";
	}
}

class Woodwind extends Wind
{
	public String toString()
	{
		return "Woodwind";
	}
}

public class Music5
{
	// Doesn't care about type, so new types
	// added to the system still work right:
	static void tune( Playable i )
	{
		// ...
		i.play( Note.MIDDLE_C );
	}

	static void tuneAll( Playable[] e )
	{
		for( Playable i : e )
			tune( i );
	}

	public static void main( String[] args )
	{
		// Upcasting during addition to the array:
		Playable[] orchestra = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };
		tuneAll( orchestra );
	}
}