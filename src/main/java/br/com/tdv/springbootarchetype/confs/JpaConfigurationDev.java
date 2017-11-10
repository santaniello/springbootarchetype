package br.com.tdv.springbootarchetype.confs;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@Profile("dev")
public class JpaConfigurationDev extends JpaConfiguration {
	    
		@Bean(name="dsDesenv")
	    public DataSource dataSource() {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			try {
				cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			cpds.setJdbcUrl("jdbc:oracle:thin:@oracle-tdp.tdv.lan:1521/tdp");
			cpds.setUser("tdvadm");
			cpds.setPassword("aged12");
			cpds.setMinPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(20);
			cpds.setMaxStatements(180);
			return cpds;
	    }

	    @Bean
		public Properties additionalProperties() {
			Properties props = new Properties();
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			props.setProperty("hibernate.show_sql", "true");
			props.setProperty("hibernate.hbm2ddl.auto", "update");
			return null;
		}
	 

}
