package geekbrains.stackcalc;

import java.util.*;

public class StackCalc
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Stack<Double> stack = new Stack<Double>();
		TreeMap<String, Double> constants = new TreeMap<String, Double>();
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner( System.in );
		
		Map<String, Cmd> cmds = new HashMap<String, Cmd>();
		cmds.put( "PUSH", new Push() );
		cmds.put( "PRINT", new Print() );
		cmds.put( "PUSHCN", new Pushcn() );
		cmds.put( "DEFINE", new Define() );
		cmds.put( "ADD", new Add() );
		cmds.put( "OUT", new Out() );
		cmds.put( "MULT", new Mult() );
		cmds.put( "DIV", new Div() );
		cmds.put( "SUB", new Sub() );
		
		while( true )
		{
			String line = s.nextLine();
			
			String[] parts = line.split(" ");
			String cmdName = parts[ 0 ].toUpperCase();
			
			try
			{
				cmds.get( cmdName ).exec( stack, parts, constants );
			}
			catch( Throwable ex )
			{
				System.out.println( "ERROR! WRONG INPUT!" );
			}
		}
	}

}
