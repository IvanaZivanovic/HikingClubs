package com.comtrade.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {
	private Connection connection;
	private static Konekcija konekcija;
	
	private Konekcija () {
	}
	public Connection getConnection() {
		return connection;
	}
	
	public static Konekcija getInstanca() {
		if (konekcija == null) {
			konekcija = new Konekcija();
		}
		return konekcija;
	}
	
	public void pokreniTransakciju() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/planinarski_klub", "root","");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public void potvrdiTransakciju() {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ponistiTransakciju() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
	public void zatvoriKonekciju() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
