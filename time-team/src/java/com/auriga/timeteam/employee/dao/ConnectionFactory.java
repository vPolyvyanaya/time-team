package com.auriga.timeteam.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.auriga.timeteam.employee.properties.AbstractPropertiesBase;
import com.auriga.timeteam.employee.properties.CachedFileProperties;

public class ConnectionFactory {
	AbstractPropertiesBase cachedProperties;

    private static ConnectionFactory connectionFactory = null;
    
    private ConnectionFactory() {
    	cachedProperties = CachedFileProperties.getInstance();
        try {        	
            Class.forName(cachedProperties.getProperty("database.driver"));
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
    }
    
    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
                connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }


    public Connection getConnection() throws SQLException {
            Connection conn = null;
            conn = DriverManager.getConnection(getConnectionURL(),
            		 cachedProperties.getProperty("database.user"),
            		 cachedProperties.getProperty("database.password"));
           // System.out.println(cachedProperties.getProperty("database.password"));
            return conn;
    }
    
    private String getConnectionURL(){
    	return  cachedProperties.getProperty("database.jdbcUrl")
				+"://"+ cachedProperties.getProperty("database.host")
				+":"+cachedProperties.getProperty("database.port")
				+"/"+cachedProperties.getProperty("database.name");
    }    
}