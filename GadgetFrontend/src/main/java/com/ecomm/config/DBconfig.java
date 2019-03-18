package com.ecomm.config;

import java.sql.DriverManager;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")

public class DBconfig 
{
@Bean
public DataSource getH2DataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	 dataSource.setDriverClassName("org.h2.driver");
	 dataSource.setUrl("jdbc:h2:tcp://localhost/~/test123");
	 dataSource.setUsername("admin");
	 dataSource.setPassword("admin");
	System.out.println("===Data source obj crated");
	return dataSource;
	}
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory() 
{
	Properties hibernateProp=new Properties();
	hibernateProp.put("hibernate.hbm2ddl.auto","update");
	hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
	factory.addProperties(hibernateProp);
	SessionFactory SessionFactory = factory.buildSessionFactory();
	System.out.println("---Session factory obj created===");
	return SessionFactory;
	
	
}
@Bean("txManager")
public HibernateTransactionManager getHibernateTransactionManage(SessionFactory sessionFactory)
{
	System.out.println("===Hibernate transcaction manager===");
	return new HibernateTransactionManager(sessionFactory);
}

}


