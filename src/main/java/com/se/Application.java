package com.se;

import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;


@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class
		 })
public class Application {
	public static void main(String[] args) {
		System.out.println("Starting real_estate service");
		SpringApplication.run(Application.class, args);
	}

}
