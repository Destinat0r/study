package geekbrains.stackcalc;

import java.util.Stack;
import java.util.TreeMap;

public class Define implements Cmd
{
	public void exec( Stack<Double> stack, String[] parts, TreeMap<String, Double> constants )
	{
		String constName = parts[ 1 ];
		double constVal = Double.valueOf( parts[ 2 ] );
		constants.put( constName, constVal );
	}
}
