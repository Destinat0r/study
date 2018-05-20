package com.firingground.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLtest
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
		Class.forName( "com.mysql.cj.jdbc.Driver" );
		try 
		(
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/cccp?autoReconnect=true&useSSL=false&serverTimezone=UTC", "root", "root" );
			PreparedStatement ps = conn.prepareStatement( "INSERT INTO chemicals (id, name, weight) VALUES (?, ?, ?)" );
		)
		{
			ps.setInt( 1, 3 );
			ps.setString( 2, "Aurum" );
			ps.setString( 3, "6" );
			ps.execute();
		}
	}

}
