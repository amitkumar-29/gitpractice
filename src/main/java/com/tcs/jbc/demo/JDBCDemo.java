package com.tcs.jbc.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo {
public static void main(String[] args) {
	String DB_URL="jdbc:mysql://localhost/practice";
	String DB_USER="root";
	String DB_PASSWORD="Nuvelabs123$";
	try(Connection connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			Statement statement=connection.createStatement();){
	//	create();
		retrieve(statement);
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
}
private static void retrieve(Statement statement) throws SQLException {
	ResultSet resultSet=statement.executeQuery("select * from regions");
	while(resultSet.next()) {
		System.out.println(resultSet.getInt(1));
		System.out.println(resultSet.getNString("REGION_NAME"));
	}
}
private static void create(Statement statement) throws SQLException {
	statement.execute("INSERT INTO REGIONS VALUES(4000,'INDIA')"); //insert

}
}
