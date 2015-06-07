package data;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectMySQL {
	public Connection getConnection() throws Exception{
		String driverClass=null;
		String jdbcurl=null;
		String user=null;
		String password=null;
		
		InputStream in=getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		properties.load(in);
		driverClass=properties.getProperty("driver");
		jdbcurl=properties.getProperty("jdbcurl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		
		Driver driver=(Driver) Class.forName(driverClass).newInstance();
		Properties info=new Properties();
		info.put("user",user);
		info.put("password", password);
		Connection conn=driver.connect(jdbcurl,info);
		return conn; 
	}
}
