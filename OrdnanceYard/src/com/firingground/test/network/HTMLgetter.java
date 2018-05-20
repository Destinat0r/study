package com.firingground.test.network;

import java.io.*;
import java.net.*;
import java.util.regex.*;

public class HTMLgetter
{
	private Socket socket;
	private String fileName = "saved.json";
	private String hostName;
	private String request;

	// -----------------------------------------------------------------------------------------------------------------
	public HTMLgetter( String hostName )
	{
		this.hostName = hostName ;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public String getFileName()
	{
		return fileName;
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void setFileName( String fileName )
	{
		this.fileName = fileName;
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void Main( String[] args ) throws Exception
	{
		sendRequest();
		getResponceToAfile();
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void sendRequest() throws Exception
	{
		this.socket = new Socket( hostName, 80 );
		try
		{
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("GET /posts HTTP/1.0");
			pw.println("Host: " + hostName );
			pw.println("");
			pw.flush();
			System.out.println( "Запрос отправлен \n" );
		}
		catch( Exception e )
		{
			socket.close();
			throw new Exception( "Ошибка при отправке запроса: " + e.getMessage(), e );
		}

		System.out.println( "Ждем ответ сервера..." );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void getResponceToAfile( ) throws IOException
	{
		String responce = null;
		BufferedInputStream inputFromServer = new BufferedInputStream( socket.getInputStream() );
		StringBuilder builder = new StringBuilder();
		int byteOfInput = 0;
		while( (byteOfInput = inputFromServer.read()) != -1 )
		{
			builder.append( (char)byteOfInput );
		}
		socket.close();
		responce = builder.toString();
		String clearJSON = responce.substring( responce.indexOf( "[" ) ).trim();

		try (FileOutputStream toFile = new FileOutputStream( fileName ))
		{
			toFile.write( clearJSON.getBytes() );
			;
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		System.out.println( "Ответ сервера получен и записан в файл " + fileName + "\n" );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public String getHostName() throws Exception
	{
		String host;
		Pattern pattern = Pattern.compile( "(?<=Host: ).+(?=\r\n)" );
		Matcher matcher = pattern.matcher( request );
		if( matcher.find() )
		{
			host = matcher.group();
			return host;
		}
		throw new Exception( "Host not found." );

	}

	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Exception
	{
		try
		{
			new HTMLgetter( "jsonplaceholder.typicode.com" ).Main( args );
		}
		catch( UnknownHostException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}
}
