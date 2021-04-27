package com.project.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.project")
public class HibernateConfig {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/productdetails?useSSL=false");
		dataSource.setUsername("###");
		dataSource.setPassword("#####");
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql","none");
		properties.put("hibernate.id.new_generator_mappings", "false");
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setHibernateProperties(hibernateProperties());
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan(new String [] {"com.project.entity"});
		return factoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
