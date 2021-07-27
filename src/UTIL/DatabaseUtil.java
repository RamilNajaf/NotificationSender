package UTIL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import domain.Config;

public class DatabaseUtil {
	
	public static Config read() throws FileNotFoundException, IOException {
		Config config=new Config();

		Properties properties = new Properties();
		
		properties.load(new FileInputStream("config.properties"));
		config .setDriver(properties.getProperty("jdbc.driver"));
		config.setUrl(properties.getProperty("jdbc.url"));
		config.setUsername(properties.getProperty("jdbc.username"));
		config.setPassword(properties.getProperty("jdbc.password"));
			
		return config;
	}
	
	public static Connection connect() throws Exception {

		Config config = read();

		Class.forName(config.getDriver());
		Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),config.getPassword());
		connection.setAutoCommit(false);

		return connection;

	}

}
