package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost/iscritticorsi?user=root&password=alessia01";
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Errore di connessione!");
			e.printStackTrace();
			return null;
		}
	}
}