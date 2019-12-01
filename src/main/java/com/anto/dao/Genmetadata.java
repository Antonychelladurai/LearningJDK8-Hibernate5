package com.anto.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.anto.dao.*;

public class Genmetadata {

	Properties props = new Properties();

	Configuration configuration = new Configuration();
	private static SessionFactory sessionFactory;

	SessionFactory getMetaData() {

//		props.put(Environment.DRIVER, value);
		
		
		// Properties settings = new Properties();
		props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/Hibernate?useSSL=false");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "12345678");
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		props.put(Environment.HBM2DDL_AUTO, "create-drop");
		props.put(Environment.AUTOCOMMIT, "true");
		configuration.setProperties(props);
		configuration.addAnnotatedClass(DBProduct.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;

	}
}
