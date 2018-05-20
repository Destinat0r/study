package geekbrains.stackcalc;

import java.util.Stack;
import java.util.TreeMap;

public class Print implements Cmd
{
	public void exec( Stack<Double> stack, String[] parts, TreeMap<String, Double> constants )
	{
		System.out.println( stack );
	}
	
}
