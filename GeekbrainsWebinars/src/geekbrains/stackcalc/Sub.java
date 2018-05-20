package geekbrains.stackcalc;

import java.util.Stack;
import java.util.TreeMap;

public class Sub implements Cmd
{
	public void exec( Stack<Double> stack, String[] parts, TreeMap<String, Double> constants )
	{
		double val = Double.valueOf( stack.pop() - stack.pop() );
		stack.push( val );
	}
	
}
