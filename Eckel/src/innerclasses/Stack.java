package innerclasses;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T>
{
	private LinkedList<T> storage = new LinkedList<T>();

	public void push( T v )
	{
		storage.addFirst( v );
	}

	public T peek()
	{
		return storage.getFirst();
	}

	public T pop()
	{
		return storage.removeFirst();
	}

	public boolean empty()
	{
		return storage.isEmpty();
	}

	public String toString()
	{
		return storage.toString();
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
		Stack<String> stack = new Stack<String>();
		FileInputStream input = new FileInputStream("D:/!!Learn Java/Projects/Study/Eckel/src/holding/input.txt");
		ArrayList<String> charList = new ArrayList<String>();
		int i = 0;

		while( i != -1 )
		{
			i = input.read();
			charList.add( "" + ((char)i) );
		}
		input.close();
		
		System.out.println( charList );
		Iterator<String> it = charList.iterator();
		
		String next;
		while( it.hasNext() )
		{
			next = it.next();
			switch( next )
			{
				case "+":
					next = it.next();
					stack.push( next );
					break;
				case "-":
					System.out.print( stack.pop() );
					break;
			}
		}
	}

}