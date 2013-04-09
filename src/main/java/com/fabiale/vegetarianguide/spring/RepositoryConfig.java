package com.fabiale.vegetarianguide.spring;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class RepositoryConfig {

	// ${jdbc.driverClassName}
	@Value("${hibernate.dialect}") private String hibernateDialect; 
	@Value("${hibernate.show_sql}") private String hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
	
	@Bean
	public URI dbUrl() throws URISyntaxException { 
		return new URI(System.getenv("DATABASE_URL"));
	}

	@Bean()
	public DataSource dataSource() throws URISyntaxException {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:postgresql://" + dbUrl().getHost() + ":" + dbUrl().getPort() + dbUrl().getPath() );
		ds.setUsername(dbUrl().getUserInfo().split(":")[0]);
		ds.setPassword(dbUrl().getUserInfo().split(":")[1]);
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws URISyntaxException {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws URISyntaxException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan(new String[] { "com.fabiale.vegetarianguide" });
		return sessionFactory;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		return properties;
	}
}
