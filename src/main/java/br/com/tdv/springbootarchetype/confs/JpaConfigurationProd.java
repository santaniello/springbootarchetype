package br.com.tdv.springbootarchetype.confs;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@PropertySource("classpath:datasource.properties")
@Profile("prod")
public class JpaConfigurationProd extends JpaConfiguration {
	    
	    @Value("${jndi.datasource.tomcat}")
	    private String jndiDatasourceTomcat;	 
	  
	    @Bean(name="dsProducao")
	    public DataSource dataSource() {
	    	JndiDataSourceLookup dataSource = new JndiDataSourceLookup();
		    dataSource.setResourceRef(true);
		    return dataSource.getDataSource(jndiDatasourceTomcat);
	    }

	    @Bean(name="additionalProperties")
		public Properties additionalProperties() {
			Properties props = new Properties();
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			props.setProperty("hibernate.show_sql", "true");
			props.setProperty("hibernate.hbm2ddl.auto", "update");
			return null;
		}
}
