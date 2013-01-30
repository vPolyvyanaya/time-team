package com.auriga.timeteam.employee.properties;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {
	
	private Properties props = new Properties();

	/**
	 * @param args
	 */
	public PropertyReader(String path) {
		try {
			FileInputStream ins = new FileInputStream(path);
			props.load(ins);				
		}catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}catch (IOException e) {
			System.out.println("IO Error!");
		} 		
	}
	
	public Properties getProperties(){		
		return props;
	}

}
