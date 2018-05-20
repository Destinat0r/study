package geekbrains;

import java.io.*;
import java.security.*;
import java.util.*;
import com.firingground.test.HashFiles;

public class DuplicateFileFinder
{
	private String path;
	private PrintWriter logWriter;

	public DuplicateFileFinder( String path ) throws Throwable
	{
		this.path = path;
		this.logWriter = new PrintWriter( path + "/log.txt", "UTF-8" );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public boolean compareByHash( File f1, File f2 ) throws Exception
	{
		String firstFileHash = HashFiles.hashFromFile( f1.getName() );
		String secondFileHash = HashFiles.hashFromFile( f2.getName() );
		
		return firstFileHash.equals( secondFileHash );
	}

	// -----------------------------------------------------------------------------------------------------------------
	private void logResults( String firstFileName, String secondFileName ) throws FileNotFoundException, UnsupportedEncodingException
	{
		this.logWriter.println( firstFileName + HashFiles.rowOfSymbols( 100 - firstFileName.length(), "-" ) + secondFileName );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void findDublicates() throws Throwable, UnsupportedEncodingException
	{
 		ArrayList<File> files = HashFiles.getAllFilesFrom( new File( this.path ) );
 		TreeMap<String, String> nameAndHashMap = getHashMap();
 		
 		for( int i = 0; i < files.size(); ++i )
		{
 			File fileToCompare = files.get( i );
			String fileToCompareName = files.get( i ).getName();
			System.out.println( "Ищем дубли  " + fileToCompareName );
			for( int j = i + 1; j < files.size(); ++j )
			{
				File nextFileToCompare = files.get( j );
				String nextFileToCompareName = files.get( j ).getName();
				if( nameAndHashMap.get( fileToCompareName ).equals( nameAndHashMap.get( nextFileToCompareName ) ) )
				{
					logResults( fileToCompare.getPath(), nextFileToCompare.getPath() );
				}
			}
		}
		this.logWriter.close();
		System.out.println( "Готово!" );
	}
	
	public TreeMap<String, String> getHashMap() throws GeneralSecurityException, Exception
	{
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		ArrayList<File> files = HashFiles.getAllFilesFrom( new File( this.path ) );
		
		for( int i = 1; i <= files.size(); i++ )
		{	
			File currentFile = files.get(i);
			String fileName = currentFile.getName();
			System.out.printf( " (%d)  %s\n", i, fileName );
			String fileHash = HashFiles.hashFromFile( currentFile.getPath( ) );
			System.out.println( fileHash );
			System.out.println();
			map.put( fileName, fileHash );
		}
		
		return map;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
		DuplicateFileFinder instance = new DuplicateFileFinder( "F:/BOOKS/Альтернативная наука" );
		instance.findDublicates();
	}
}
