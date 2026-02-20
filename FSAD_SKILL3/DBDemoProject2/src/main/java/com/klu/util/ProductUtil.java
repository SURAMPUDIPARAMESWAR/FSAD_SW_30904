package com.klu.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductUtil{
	private static SessionFactory sf;
	
	static {
		try {
			sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		}catch(Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError();
			
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
