package com.mattvalli.portfolio.configuration;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.mattvalli.portfolio.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
	// CONSTANTS
	private static final boolean DEBUG_CONFIGURATION = true;
 
    @Autowired
    private Environment environment;
 
    /* Instantiates a Hibernate SessionFactory Object
     * 
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSourcePortfolio());
        sessionFactory.setPackagesToScan(new String[] { "com.mattvalli.portfolio.model", "com.mattvalli.RapidFramework" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
    
    @Bean
    public LocalSessionFactoryBean sessionFactoryUserSystem() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceUserSystem());
        sessionFactory.setPackagesToScan(new String[] { "com.mattvalli.RapidFramework.Model", "com.mattvalli.RapidFramework" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
     
    /* Instantiates and configures a DataSource Object for accessing a database
     * 
     * Configuration retrieves property values from the Environment Object. The
     * @PropertySource Annotation specifies the file to retrieve properties.
     */
    @Bean
    public DataSource dataSourcePortfolio() {
    	
    	if (DEBUG_CONFIGURATION) {
	    	System.out.println("Reading from application.properties...");
	    	System.out.println("Hibernate Driver: " + environment.getRequiredProperty("jdbc.driverClassName"));
	    	System.out.println("MySQL URL: " 		+ environment.getRequiredProperty("jdbc.url.portfolio"));
	    	System.out.println("MySQL Username: " 	+ environment.getRequiredProperty("jdbc.username"));
	    	System.out.println("MySQL Password: " 	+ environment.getRequiredProperty("jdbc.password"));
    	}
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url.portfolio"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        
        return dataSource;
    }
    
    @Bean
    public DataSource dataSourceUserSystem() {
    	if (DEBUG_CONFIGURATION) {
	    	System.out.println("Reading from application.properties...");
	    	System.out.println("Hibernate Driver: " + environment.getRequiredProperty("jdbc.driverClassName"));
	    	System.out.println("MySQL URL: " 		+ environment.getRequiredProperty("jdbc.url.user_system"));
	    	System.out.println("MySQL Username: " 	+ environment.getRequiredProperty("jdbc.username"));
	    	System.out.println("MySQL Password: " 	+ environment.getRequiredProperty("jdbc.password"));
    	}
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url.user_system"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        
        return dataSource;
    }
    
    /* Instantiates and configures a Properties Object for configuring a Hibernate
     * 
     * Configuration retrieves property values from the Environment Object. The
     * @PropertySource Annotation specifies the file to retrieve properties.
     */
    private Properties hibernateProperties() {
    	
    	if (DEBUG_CONFIGURATION) {
    		System.out.println("Hibernate Dialect: " + environment.getRequiredProperty("hibernate.dialect"));
    		System.out.println("Hibernate Dialect: " + environment.getRequiredProperty("hibernate.show_sql"));
    		System.out.println("Hibernate Dialect: " + environment.getRequiredProperty("hibernate.format_sql"));
    	}
    	
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;        
    }
     
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}
