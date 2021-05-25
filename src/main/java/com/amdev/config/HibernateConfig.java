package com.amdev.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hbn.properties")
public class HibernateConfig {
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hibernate.driver}")
	private String driver;
	
	@Value("${hibernate.jdbcUrl}")
	private String jdbcUrl;
	
	@Value("${hibernate.user}")
	private String user;
	
	@Value("${hibernate.password}")
	private String password;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() throws PropertyVetoException {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", dialect);
	    hibernateProperties.put("hibernate.show_sql", showSql);
	    
	    bean.setHibernateProperties(hibernateProperties);
	    bean.setDataSource(getDataSource());
	    bean.setPackagesToScan("com.amdev");
	    return bean;
	}
	
	@Bean
	public ComboPooledDataSource getDataSource() throws PropertyVetoException {
	  ComboPooledDataSource dataSource = new ComboPooledDataSource();

	  dataSource.setDriverClass(driver);
	  dataSource.setJdbcUrl(jdbcUrl);
	  dataSource.setUser(user);
	  dataSource.setPassword(password);
	  dataSource.setAcquireIncrement(10);
	  dataSource.setIdleConnectionTestPeriod(0);
	  dataSource.setInitialPoolSize(5);
	  dataSource.setMaxIdleTime(0);
	  dataSource.setMaxPoolSize(50);
	  dataSource.setMaxStatements(100);
	  dataSource.setMinPoolSize(5);

	  return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() throws PropertyVetoException {
	  JdbcTemplate template = new JdbcTemplate();     
	  template.setDataSource(getDataSource());        
	  return template;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() throws PropertyVetoException {
	  HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	  transactionManager.setSessionFactory(getSessionFactory().getObject());
	  return transactionManager;
	}
}
