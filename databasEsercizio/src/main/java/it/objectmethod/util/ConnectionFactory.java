package it.objectmethod.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:33060/world";
	private static final String USER = "omdev";
	private static final String PASSWORD = "omdev";

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore connessione");
		}

		return conn;
	}
}
