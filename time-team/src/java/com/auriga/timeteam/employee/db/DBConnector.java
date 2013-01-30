package com.auriga.timeteam.employee.db;

import java.sql.*;
//import java.

import com.auriga.timeteam.employee.properties.AbstractPropertiesBase;
import com.auriga.timeteam.employee.properties.CachedFileProperties;

public class DBConnector {
	AbstractPropertiesBase cachedProperties;
	
	public DBConnector() {
		cachedProperties = CachedFileProperties.getInstance();		
	}
	
	public void connect()throws Exception{
		Connection connection;
		 try {
			Class.forName(cachedProperties.getProperty("database.driver")); 
			String connectionUrl = cachedProperties.getProperty("database.url")
					+ cachedProperties.getProperty("database.host")
					+":"+cachedProperties.getProperty("database.port")
					+"/"+cachedProperties.getProperty("database.name");
			connection = DriverManager.getConnection(connectionUrl,
					 cachedProperties.getProperty("database.user"), 
					 cachedProperties.getProperty("database.password"));
		 } catch (ClassNotFoundException e) {
	         throw new Exception(e);
	     } catch (SQLException e) {
	         throw new SQLException(e);
	     } catch (Exception e) {
	         throw new Exception(e);
	     }
        if (connection == null) {
            System.out.println("��� ���������� � ��!");
            System.exit(0);
        } 
        System.out.println("OK!");
        /*Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users"); 
        while (rs.next()) {
            System.out.println(rs.getRow() + ". " + rs.getString("firstname")
                    + "\t" + rs.getString("lastname"));
        }*/ 
        /*��� �������� Statement ������������� �����������
         * ��� ��������� � ��� �������� ������� ResultSet         */
        //stmt.close();
	}

}
