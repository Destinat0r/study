package com.firingground.test.network;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;

public class HttpClient
{
	public static void main( String[] args )
	{
		try
		{
			String header = null;
			if( args.length == 0 )
			{
				header = readHeader( System.in );
			}
			else
			{
				FileInputStream inputStream = new FileInputStream( args[ 0 ] );
				header = readHeader( inputStream );
				inputStream.close();
			}
			System.out.println( "���������: \n" + header );
			/* ������ ������������ �� ������ */
			String serverAnswer = sendRequest( header );
			/* ����� ��������� �� ������� */
			System.out.println( "����� �� �������: \n" );
			System.out.write( serverAnswer.getBytes() );
		}
		catch( Exception e )
		{
			System.err.println( e.getMessage() );
			e.getCause().printStackTrace();
		}
	}

	/**
	 * ������ ����� � ���������� ��� ���������� � ���� ������.
	 */
	public static String readHeader( InputStream stream ) throws IOException
	{
		byte[] buff = new byte[ 64 * 1024 ];
		int length = stream.read( buff );
		String header = new String( buff, 0, length );
		return header;
	}

	/**
	 * ���������� ������ � ������������ � Http ����������.
	 * 
	 * @return ����� �� �������.
	 */
	public static String sendRequest( String httpHeader ) throws Exception
	{
		/* �� http ��������� ������� ���� ������� */
		String host = null;
		int port = 0;
		try
		{
			host = getHost( httpHeader );
			port = getPort( host );
			host = getHostWithoutPort( host );
		}
		catch( Exception e )
		{
			throw new Exception( "�� ������� �������� ����� �������.", e );
		}
		/* ������������ ������ �� ������ */
		Socket socket = null;
		try
		{
			socket = new Socket( host, port );
			System.out.println( "������ �����: " + host + " port:" + port );
			socket.getOutputStream().write( httpHeader.getBytes() );
			System.out.println( "��������� ���������. \n" );
		}
		catch( Exception e )
		{
			throw new Exception( "������ ��� �������� �������: " + e.getMessage(), e );
		}
		/* ����� �� ������� ������������ � �������������� ������ */
		String res = null;
		try
		{
			InputStreamReader isr = new InputStreamReader( socket.getInputStream() );
			BufferedReader bfr = new BufferedReader( isr );
			StringBuffer sbf = new StringBuffer();
			int ch = bfr.read();
			while( ch != -1 )
			{
				sbf.append( (char)ch );
				ch = bfr.read();
			}
			res = sbf.toString();
		}
		catch( Exception e )
		{
			socket.close();
			throw new Exception( "������ ��� ������ ������ �� �������.", e );
		}
		socket.close();
		return res;
	}

	/**
	 * ���������� ��� ����� (��� ������� �����, � ������) �� http ���������.
	 */
	private static String getHost( String header ) throws ParseException
	{
		final String host = "Host: ";
		final String normalEnd = "\n";
		final String msEnd = "\r\n";

		int s = header.indexOf( host, 0 );
		if( s < 0 )
		{
			return "localhost";
		}
		s += host.length();
		int e = header.indexOf( normalEnd, s );
		e = (e > 0) ? e : header.indexOf( msEnd, s );
		if( e < 0 )
		{
			throw new ParseException( "� ��������� ������� �� ������� " + "����������� �������� ����� ������ Host.", 0 );
		}
		String res = header.substring( s, e ).trim();
		return res;
	}

	/**
	 * ���������� ����� �����.
	 */
	private static int getPort( String hostWithPort )
	{
		int port = hostWithPort.indexOf( ":", 0 );
		port = (port < 0) ? 80 : Integer.parseInt( hostWithPort.substring( port + 1 ) );
		return port;
	}

	/**
	 * ���������� ��� ����� ��� �����.
	 */
	private static String getHostWithoutPort( String hostWithPort )
	{
		int portPosition = hostWithPort.indexOf( ":", 0 );
		if( portPosition < 0 )
		{
			return hostWithPort;
		}
		else
		{
			return hostWithPort.substring( 0, portPosition );
		}
	}
}
