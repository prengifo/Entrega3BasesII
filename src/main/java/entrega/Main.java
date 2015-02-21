package main.java.entrega;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	static SessionFactory factory;
	
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object " + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
//		testEverything();
	}
	
	public static void testEverything() {
		Session session = factory.openSession();
		Transaction tx = null;
		Long userId = null;
		try {
			tx = session.beginTransaction();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!= null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}
