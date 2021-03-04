package com.nk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBC {
	public Connection jdbcConnection;
	private String sqlInstance = "RON";
	private String port = "1433";
	private String database = "Contact";
	private String nickname = "sa";
	private String password = "rona.6399";
	
	public void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			jdbcConnection = DriverManager.getConnection("jdbc:sqlserver://"+sqlInstance+":"+port+";databaseName="+database+";user="+nickname+";password="+password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
