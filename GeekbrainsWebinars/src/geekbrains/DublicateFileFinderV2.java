package geekbrains;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class DublicateFileFinderV2
{
	private String path;
	private PrintWriter logWriter;

	public DublicateFileFinderV2( String path, String encoding ) throws Throwable
	{
		this.path = path;
		this.logWriter = new PrintWriter( path + "/log.txt", encoding );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public int areTheseEqual( File f1, File f2 ) throws Exception
	{
		BufferedInputStream firstFileInput = new BufferedInputStream( new FileInputStream( f1 ) );
		BufferedInputStream secondFileInput = new BufferedInputStream( new FileInputStream( f2 )  );

		int firstFileByte;
		int secondFileByte;

		//пока не закончился один из файлов
		while( (firstFileByte = firstFileInput.read()) != -1 && (secondFileByte = secondFileInput.read()) != -1 )
		{
			if( firstFileByte != secondFileByte )
			{
				closeStream( firstFileInput, secondFileInput );
				return firstFileByte - secondFileByte ;
			}
		}

		closeStream( firstFileInput, secondFileInput );
		return 0;
	}

	// -----------------------------------------------------------------------------------------------------------------
	private void closeStream( BufferedInputStream input1, BufferedInputStream input2 ) throws Exception
	{
		input1.close();
		input2.close();
	}

	// -----------------------------------------------------------------------------------------------------------------
	private void logResults( String firstFileName, String secondFileName ) throws FileNotFoundException, UnsupportedEncodingException
	{
		this.logWriter.println( "Файл " + firstFileName + " и файл " + secondFileName + " одинаковы.\n" );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static ArrayList<File> getAllFilesFrom( File path )
	{
		ArrayList<File> allFiles = new ArrayList<File>();
		File[] folders = path.listFiles( new FileFilter(){
			@Override
			public boolean accept( File pathname )
			{
				return pathname.isDirectory();
			}
		});
		
		for( File folder : folders )
		{
			allFiles.addAll( getAllFilesFrom( folder ) );
		}
		
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
	public void findDublicates() throws Throwable, UnsupportedEncodingException
	{
 		ArrayList<File> files = getAllFilesFrom( new File( this.path ) );
 		
 		TreeSet<File> set = new TreeSet<File>( new Comparator<File>()
 		{
			@Override
			public int compare( File o1, File o2 )
			{
				try
				{	
					return areTheseEqual( o1, o2 );
				}
				catch( Exception e )
				{
					e.printStackTrace();
					throw new RuntimeException( e );
				}
			}
 		});
 		
 		for( File file : files )
		{
			if( !set.contains( file ) )
			{
				set.add( file );
			}
			else
			{
				File oldFile = set.floor(file);
				logResults( file.getName(), oldFile.getName() );
			}
		}
 		
		System.out.println( "Done!" );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
	
	}
	

}
