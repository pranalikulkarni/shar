package com.cg.student.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

static Connection con=null;
	
	public static Connection getConnection() throws IOException, SQLException

	{
		try {
			
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/OracleDS");
		con=ds.getConnection();
		}
		catch(SQLException e) {
			
		}catch(NamingException e) {
			
		}
		return con;
	}
}
