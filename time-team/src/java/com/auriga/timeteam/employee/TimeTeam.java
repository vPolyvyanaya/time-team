package com.auriga.timeteam.employee;

import com.auriga.timeteam.employee.dao.ConnectionFactory;

public class TimeTeam {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		
		try {
			connectionFactory.getConnection();
		}catch(Exception e){
			System.out.println("Exception in connectionFactory.getConnection() "+ e);
		}
	}

}
