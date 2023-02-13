package com.example.javaservernetflix2023.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.inject.Named;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@ComponentScan("com.example.javaservernetflix2023")
@EnableAutoConfiguration
public class Configuration {



    @Bean
    @Named("postgresDataSource")
    public org.springframework.jdbc.datasource.DriverManagerDataSource postgresDataSource() {
        org.springframework.jdbc.datasource.DriverManagerDataSource postgresDataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        postgresDataSource.setDriverClassName("org.postgresql.Driver");
        postgresDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        postgresDataSource.setUsername("postgres");
        postgresDataSource.setPassword("postgres");
        return postgresDataSource;
    }

    @Bean
    @Named("postgresSessionFactory")
    public org.springframework.orm.hibernate5.LocalSessionFactoryBean postgresSessionFactory() {
        org.springframework.orm.hibernate5.LocalSessionFactoryBean postgresSessionFactory = new org.springframework.orm.hibernate5.LocalSessionFactoryBean();
        postgresSessionFactory.setDataSource(postgresDataSource());
        postgresSessionFactory.setPackagesToScan("com/example/javaservernetflix2023/datamodel");
        java.util.Properties properties = new java.util.Properties();
        properties.setProperty("hibernate.properties", "org.postgresql.Driver");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql","true");
        postgresSessionFactory.setHibernateProperties(properties);
        return postgresSessionFactory;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }







}
