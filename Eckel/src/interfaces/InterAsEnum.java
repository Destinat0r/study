package interfaces;
import static utils.Print.*;

public interface InterAsEnum
{
	int FALLOUT = 1997, FALLOUT_2 = 1999, GOTHIC = 2002, GOTHIC_2 = 2004;
	
	public static void main( String[] args )
	{
		print( InterAsEnum.FALLOUT_2 );
	}
}
