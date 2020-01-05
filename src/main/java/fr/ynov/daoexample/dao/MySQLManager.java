package fr.ynov.daoexample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {

	private static MySQLManager instance;
	private Statement statement = null;
	private Connection connection = null;
	private String url = "jdbc:mysql://localhost:3306/blog?serverTimezone=Europe/Paris";
	private String utilisateur = "root";
	private String motDePasse = "root";

	private MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			this.statement = this.connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public static synchronized MySQLManager getInstance() {
		if (instance == null) {
			instance = new MySQLManager();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
