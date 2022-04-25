package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Unit {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Give accurate information: username, password, DBServer/DBName 
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/electricity?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

//Insert Units	
	public String insertUnit(String uAccNo, String uDate, String UnitAmount, String PriceForPerUnit, String Total) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			// Create a statement in advance
			String query = " insert into unit1(`uID`,`uAccNo`,`uDate`,`UnitAmount`,`PriceForPerUnit`,`Total`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// Binding the values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, uAccNo);
			preparedStmt.setString(3, uDate);
			preparedStmt.setString(4, UnitAmount);
			preparedStmt.setString(5, PriceForPerUnit);
			preparedStmt.setString(6, Total);
			
			// Executing the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the unit.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	

}
