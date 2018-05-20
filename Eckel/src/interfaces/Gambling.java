package interfaces;

import java.util.Random;

public class Gambling
{
	public static void playGame( Game game )
	{
		for( int i = 0; i < 5; i++ )
		{
			game.tryYourLuck();
		}
		System.out.println( "====================" );
	}
	
	public static void main( String[] agrs )
	{
		playGame( new Dice() );
		playGame( new Coin() );
	}
}

interface Game
{
	void tryYourLuck();
}

interface GambleFactory
{
	Game getGame();
}

class Dice implements Game
{
	Random rand = new Random();

	public void tryYourLuck()
	{
		int firstDie = rand.nextInt( 6 ) + 1;
		int secondDie = rand.nextInt( 6 ) + 1;
		System.out.printf( "Выпало: %d и %d! Итого: %d\n", firstDie, secondDie, firstDie + secondDie );
	}
}

class Coin implements Game
{

	Random rand = new Random();
	String[] sides = new String[] { "Решка", "Орел" };

	public void tryYourLuck()
	{
		System.out.println( "====================" );
	}

}