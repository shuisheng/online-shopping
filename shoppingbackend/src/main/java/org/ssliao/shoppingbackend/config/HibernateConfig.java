package org.ssliao.shoppingbackend.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"org.ssliao.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
    private final static String DB_DRIVER = "org.h2.Driver";
    private final static String DB_DIALECT = "org.hibernate.dialect.H2Dialect";
    private final static String DB_USERNAME = "sa";
    private final static String DB_PASSWORD = "";

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);

        return dataSource;
    }

    @Bean(value = "SessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

        builder.addProperties(getHibernateProperties());
        builder.scanPackages("org.ssliao.shoppingbackend.dto");
        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.dialect", DB_DIALECT);
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
        return hibernateTransactionManager;
    }
}
