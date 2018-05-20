package com.firingground.test;

import java.io.*;
import java.security.*;
import java.util.*;

public class HashFiles
{
	// -----------------------------------------------------------------------------------------------------------------
	public static String hashFromString( String input ) throws NoSuchAlgorithmException
	{
		MessageDigest sha1 = MessageDigest.getInstance( "sha-1" );
		byte[] bytes = sha1.digest( input.getBytes() );
		String hash = bytesToHash( bytes );
		return hash;
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static String hashFromFile( String filename ) throws NoSuchAlgorithmException, Exception
	{
		byte[] bytes = bytesFromFile( filename );
		return bytesToHash( bytes );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static byte[] bytesFromFile( String filename ) throws NoSuchAlgorithmException, Exception
	{
		MessageDigest sha1 = MessageDigest.getInstance( "sha-1" );
		InputStream stream = new FileInputStream( filename );
		byte[] buffer = new byte[ 1024 ];
		
		int numRead;
		do
		{
			numRead = stream.read( buffer );
			if( numRead > 0 )
			{
				sha1.update( buffer, 0, numRead );
			}
		}
		while ( numRead != -1 );
		stream.close();
		
		return sha1.digest();
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static String bytesToHash( byte[] bytes )
	{
		StringBuilder builder = new StringBuilder();
		
		for( byte b : bytes )
		{
			builder.append( String.format( "%02X", b ) );
		}
		return builder.toString(); 
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static void getHashesOfDirectory( String path ) throws Exception
	{
		try ( PrintWriter writer = new PrintWriter( path + " hash.txt", "UTF-8" ); )
		{
			ArrayList<File> files = getAllFilesFrom( new File( path ) );
			
			for( File file : files )
			{	
				String filename = file.getName();
				writer.println( hashFromFile( filename ) + rowOfSymbols( 70 - filename.length(), "-" ) + filename );
			}
		}
		System.out.println( "Готово!" );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static String rowOfSymbols( int i, String symbol )
	{
		String rowOfSymbols = "";
		for( int j = 0; j < i; ++j )
		{
			rowOfSymbols += symbol;
		}
		return rowOfSymbols;
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static ArrayList<File> getAllFilesFrom( File path )
	{
		ArrayList<File> allFiles = new ArrayList<File>();
		
		//получаем только папки из текущего каталога
		File[] folders = path.listFiles( new FileFilter(){ 
			@Override
			public boolean accept( File pathname )
			{
				return pathname.isDirectory();
			}
		});
		
		//в каждой папке ищем папки...
		for( File folder : folders )
		{
			allFiles.addAll( getAllFilesFrom( folder ) );
		}
		
		//...и файлы
		File[] files = path.listFiles( new FileFilter(){
			@Override
			public boolean accept( File pathname )
			{
				return pathname.isFile();
			}
		});
		
		allFiles.addAll( Arrays.asList( files ) );
		
		return allFiles;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Exception
	{
		System.out.println( HashFiles.bytesFromFile( "D:/!coding/!BOOK PROJECT/Part3.7z" ) ); 
	}

}
