package holding;

public class App3
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		int codePoint = 128149;
		char[] charPair = Character.toChars(codePoint);

		String str = new String(charPair, 0, 2);
		System.out.println("First code point: " + str.codePointAt(0));    // 128149, worked
		String str2 = charPair.toString();
		System.out.println("Second code point: " + str2.codePointAt(0));  // 91, didn't work
		String str3 = new String(charPair);
		System.out.println("Third code point: " + str3.codePointAt(0));   // 128149, worked
		String str4 = String.valueOf(codePoint);
		System.out.println("Fourth code point: " + str4.codePointAt(0));  // 49, didn't work
		String str5 = new String(new int[] {codePoint}, 0, 1);
		System.out.println("Fifth code point: " + str5.codePointAt(0));
	}

}
