package geekbrains;

import java.util.Comparator;

public class ReverseComparator implements Comparator<Object>
{

	public int compare( Object o1, Object o2 )
	{
		int i1 = (Integer) o1;
		int i2 = (Integer) o2;
		return i2 - i1;
	}

}
