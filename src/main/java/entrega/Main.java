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
		
		addEvent("La paja mistica");
	}
	
	public static Long addEvent(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		Long EventId = null;
		try {
			tx = session.beginTransaction();
			Event evento = new Event(name, null);
			EventId = (Long) session.save(evento);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!= null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return EventId;
	}
	
}
