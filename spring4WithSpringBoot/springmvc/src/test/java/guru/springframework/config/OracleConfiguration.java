package guru.springframework.config;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ConfigurationProperties("oracle") //when spring looks into properties file, it will look for oracle first like oracle.username and oracle.password
public class OracleConfiguration {
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String url;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Bean
	
	DataSource dataSource() throws SQLException{
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		
		/*  Set below when we have RAC, you can't setup this advance using spring boot properties
		 *	dataSource.setImplicitCachingEnabled(true);
			dataSource.setFastConnectionFailoverEnabled(true); 
		 */
		return dataSource;
	}
	
	

}
