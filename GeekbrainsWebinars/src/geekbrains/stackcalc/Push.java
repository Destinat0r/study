package geekbrains.stackcalc;

import java.util.*;

public class Push implements Cmd
{
	public void exec( Stack<Double> stack, String[] parts, TreeMap<String, Double> constants )
	{
		try
		{
			stack.push( Double.valueOf( parts[ 1 ] ) );
		}
		catch( Throwable ex )
		{
			System.out.println( "ERROR! Correct form of command is: \"<command><sinle space><value>\" " );
		}
	}
}
