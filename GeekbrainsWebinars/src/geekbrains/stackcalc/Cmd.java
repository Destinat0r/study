package geekbrains.stackcalc;

import java.util.Stack;
import java.util.TreeMap;

public interface Cmd
{
	void exec( Stack<Double> stack, String[] parts, TreeMap<String, Double> constants );
}
