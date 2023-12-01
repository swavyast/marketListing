package com.ml.users;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class DatabaseConfiguration {
	static SessionFactory sessionFactory=null;
	static {
		try {
			Configuration cfg=new Configuration();
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Vendor.class);
			//cfg.addAnnotatedClass(Supplier.class);
			//cfg.addAnnotatedClass(RegionalSupplier.class);
			//cfg.addAnnotatedClass(GlobalSupplier.class);
			//cfg.addAnnotatedClass(Administrator.class);
			cfg.addAnnotatedClass(Address.class);
			//cfg.addAnnotatedClass(Location.class);
			cfg.addAnnotatedClass(Bank.class);
			cfg.addAnnotatedClass(Account.class);
			Properties properties=new Properties();
			properties.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
			properties.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
			properties.put(Environment.USER, "system");
			properties.put(Environment.PASS, "0");
			properties.put(Environment.SHOW_SQL, "true");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.Oracle12cDialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			cfg.setProperties(properties);
			StandardServiceRegistryBuilder ssrBuilder=new StandardServiceRegistryBuilder();
			ServiceRegistry sr=ssrBuilder.applySettings(cfg.getProperties()).build();
			sessionFactory=cfg.buildSessionFactory(sr);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
