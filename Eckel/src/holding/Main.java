package holding;

import java.util.*;

public class Main
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		List<String> staff = new LinkedList<String>();
		staff.add( "Amy" );
		staff.add( "����" );
		staff.add( "���" );
		
		
		ListIterator<String> iter = staff.listIterator();
		iter.next();
		iter.next();
		iter.add("����");
		
		iter.add("�����");
		iter.add("���");
		iter.add("����");
		
		for( String string : staff )
		{
			System.out.println( string );
		}
	}

}
