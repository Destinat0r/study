package geekbrains.stackcalc;

import java.util.Stack;
import java.util.TreeMap;

public class Pushcn implements Cmd
{
	public void exec( Stack<Double> stack, String[] parts, TreeMap<String, Double> constants )
	{
		String constName = parts[ 1 ];
		double val = constants.get( constName );
		stack.push( val );

	}
}
