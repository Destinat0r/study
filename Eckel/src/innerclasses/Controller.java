package innerclasses;

import java.util.*;

public class Controller
{
	// A class from java.util to hold Event objects:
	private LinkedList<Event> eventList = new LinkedList<Event>();

	public void addEvent( Event c )
	{
		eventList.add( c );
	}

	public void run()
	{
		while( eventList.size() > 0 )
			// Make a copy so you're not modifying the list
			// while you're selecting the elements in it:
			for( Event e : new LinkedList<Event>( eventList ) )
				if( e.ready() )
				{
					System.out.println( e );
					e.action();
					eventList.remove( e );
				}
	}
}