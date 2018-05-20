package geekbrains;

public class Capitalizer
{
	// -----------------------------------------------------------------------------------------------------------------
	public static String caseFix( String s )
	{
		if( s.length() == 0 )
			return "";
		String[] arr = s.split( " " );
		StringBuilder sb = new StringBuilder();

		for( String word : arr )
		{
			word = word.substring( 0, 1 ).toUpperCase() + word.substring( 1 ).toLowerCase();
			sb.append( word + " " );
		}

		s = sb.toString().trim();

		return s;
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
//		System.out.println( "A".codePointAt( 0 ) );
//		System.out.println( "a".codePointAt( 0 ) );
		String s = "в ле—” рќдиЋась Єлќчкј";
		s = Capitalizer.caseFix3( s );
		System.out.println( s );
		System.out.println( Capitalizer.caseFix3( "helLo, mOskOw" ) );
		System.out.println( Capitalizer.caseFix( "" ) );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static String caseFix2( String s )
	{
		StringBuilder sb = new StringBuilder( s );

		for( int i = 0; i < sb.length(); ++i )
		{
			String firstLetter = "" + sb.charAt( i );

			if( i == 0 || sb.charAt( i - 1 ) == ' ' )
				sb.replace( i, i + 1, firstLetter.toUpperCase() );
			else
			{
				sb.replace( i, i + 1, firstLetter.toLowerCase() );
			}
		}

		return sb.toString();
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static String caseFix3( String s )
	{
		StringBuilder sb = new StringBuilder();
		
		for( int i = 0; i < s.length(); ++i )
		{
			String firstLetter = s.substring( i, i + 1 );
			if( i == 0 || s.charAt( i - 1 ) == ' ' )
			{
				sb.append( firstLetter.toUpperCase() );
			}
			else
			{
				sb.append( firstLetter.toLowerCase() );
			}
		}
		return sb.toString();
	}
}
