package geekbrains.stackcalc;

import java.util.Stack;
import java.util.TreeMap;

public class Out implements Cmd
{

	@Override
	public void exec( Stack<Double> stack, String[] parts, TreeMap<String, Double> constants )
	{
		System.out.println( "Exiting the programm..." );
		System.exit( 0 );
	}

}
