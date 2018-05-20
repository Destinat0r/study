package geekbrains;

import java.util.*;

public class StackCalc
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Stack<Double> stack = new Stack<Double>();
		TreeMap<String, Double> constants = new TreeMap<String, Double>();
		
		Scanner s = new Scanner( System.in );
		
		while( true )
		{
			String line = s.nextLine();
			
			String[] parts = line.split(" ");
			String cmdName = parts[ 0 ].toUpperCase();
			
			if( cmdName.equals( "PUSH" ) )
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
			else if( cmdName.equals( "PRINT" ) )
			{
				System.out.println( stack );
			}
			else if( cmdName.equals( "OUT" ) )
			{
				System.exit( 0 );
			}
			else if( cmdName.equals("ADD") )
			{
				double val = Double.valueOf( stack.pop() + stack.pop() );
				stack.push( val );
			}
			else if( cmdName.equals("MULT") )
			{
				double val = Double.valueOf( stack.pop() * stack.pop() );
				stack.push( val );
			}
			else if( cmdName.equals("SUB") )
			{
				double val = Double.valueOf( stack.pop() - stack.pop() );
				stack.push( val );
			}
			else if( cmdName.equals("DIV") )
			{
				double val = Double.valueOf( stack.pop() / stack.pop() );
				stack.push( val );
			}
			else if( cmdName.equals("DEFINE") )
			{
				String constName = parts[ 1 ];
				double constVal = Double.valueOf( parts[ 2 ] );
				constants.put( constName, constVal );
			}
			else if( cmdName.equals("PUSHCN") )
			{
				String constName = parts[ 1 ];
				double val = constants.get( constName );
				stack.push( val );
			}
			else 
			{
				System.out.println( "ERROR! WRONG INPUT." );
			}
			
			s.close();
		}
	}

}
