package project.avocado.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PlayerDAO {
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;

	Properties pro;

	public PlayerDAO() {

		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));

			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void connect() {

		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
			System.out.println("DB접속 성공~!!^^*");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect
	
	private void addSong() {
		
		
		
		
		
	}
	
	

}
