package com.firingground.test.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������� ��������� � ������ ��������� ���� � ������� ��� ���������� �� ���� ��������� �� �������.
 */
public class TcpServer
{
	private static final int DEFAULT_PORT = 9999;

	public static void main( String[] args )
	{
		/* ���� ��������� �����������, ���� �������� �������� ����������� */
		int port = DEFAULT_PORT;
		if( args.length > 0 )
		{
			port = Integer.parseInt( args[ 0 ] );
		}
		/* ������� ��������� ����� �� ���������� ����� */
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket( port );
		}
		catch( IOException e )
		{
			System.out.println( "���� �����: " + port );
			System.exit( -1 );
		}
		/*
		 * ���� ���� ��� �������� � ����� ��� ������� ������, ����� ���������� � ���������� ���� -
		 * �������� ������
		 */
		Socket clientSocket = null;
		try
		{
			clientSocket = serverSocket.accept();
		}
		catch( IOException e )
		{
			System.out.println( "������ ��� ����������� � �����: " + port );
			System.exit( -1 );
		}
		/*
		 * ������ ����� �������� ����� �����, � ������� ���������� ��������� �� �������
		 */
		InputStream in = null;
		try
		{
			in = clientSocket.getInputStream();
		}
		catch( IOException e )
		{
			System.out.println( "�� ������� �������� ����� �����." );
			System.exit( -1 );
		}
		/*
		 * � ���� ���������� ������ ����� ��� ����� ������ ����� � �������� ��� ���������� ��
		 * �������
		 */
		BufferedReader reader = new BufferedReader( new InputStreamReader( in ) );
		String ln = null;
		try
		{
			while( (ln = reader.readLine()) != null )
			{
				System.out.println( ln );
				System.out.flush();
			}
		}
		catch( IOException e )
		{
			System.out.println( "������ ��� ������ ���������." );
			System.exit( -1 );
		}
	}

	
}