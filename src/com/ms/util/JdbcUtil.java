package com.ms.util;

import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtil {
	
	private static DataSource ds =null;
	
	static{
		
		Properties properties = new Properties();
		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		try {
			properties.load(in);
			ds = BasicDataSourceFactory.createDataSource(properties);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
}
