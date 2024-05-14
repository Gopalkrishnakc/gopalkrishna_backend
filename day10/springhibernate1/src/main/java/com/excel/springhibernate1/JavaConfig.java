package com.excel.springhibernate1;



import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan( basePackages = "com.excel.springhibernate1")
@EnableTransactionManagement
public class JavaConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springhibernate");
		ds.setUsername("root");
		ds.setPassword("Sa123");
		return ds;
}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.excel.springhibernate1");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
  @Bean
  public HibernateTemplate hibernateTemplate() {
	  HibernateTemplate hibernateTemplate=new HibernateTemplate();
	  hibernateTemplate.setSessionFactory(sessionFactory().getObject());
	  return hibernateTemplate;
  }
  @Bean
  public HibernateTransactionManager  hibernateTransactionManager() {
	  HibernateTransactionManager transaction=new  HibernateTransactionManager();
	  transaction.setSessionFactory(sessionFactory().getObject());
	  return transaction;
  }
  
	private final Properties hibernateProperties() {
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		return hibernateProperties;

	}
}