package hsbc.gbm.config;

import javax.sql.DataSource;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfiguration {
	private Logger logInfo = LoggerFactory.getLogger(DataSourceConfiguration.class); 
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driver}")
	private String driver;

	@Bean
	public DataSource setDatasource() {
		logInfo.info("Start To Set Datasource");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		
		logInfo.info("Set Datasource Successfully");
		
		return dataSource;
	}
}
