package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ClientDao {
	String url = "jdbc:mysql://localhost:3306/addandremovestudent";
	String uname = "root";
	String pas = "codingninja";
	Connection con;

	public ClientDao() {
		// use the reflection for load the Driver class
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create connection
		try {
			con = DriverManager.getConnection(url, uname, pas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean check(String n, String p) throws ClassNotFoundException, SQLException {

		String query1 = "select * from client where uname=? and upassword=?";

		PreparedStatement st = con.prepareStatement(query1);

		st.setString(1, n);
		st.setString(2, p);

		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			return true;

		} else {

			return false;
		}
	}

	public void set(String n, String p) throws SQLException {
		
		
		String query1 = "insert into client values(?,?)";

		PreparedStatement st = con.prepareStatement(query1);
		st.setString(1, n);
		st.setString(2, p);
		st.executeUpdate();
	}
}
