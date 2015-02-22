package main.java.entrega;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {
	static SessionFactory factory;
	static ServiceRegistry registry;
	
	public static void main(String[] args) {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			registry = new StandardServiceRegistryBuilder().applySettings(
					configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(registry);

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
	
	// Funciones para consulta
	
	public List<Promocion> promocionesPorNombre(Session session, String consulta) {
		Query query = session.createQuery("from Promocion where nombre like :nombre");
		query.setParameter("nombre", consulta);
		List<Promocion> results = query.list();
		return results;
	}
	
	public List<Object[]> promocionesPorEmpresa(Session session) {
		Query query = session.createQuery("select e.nombre, e.promociones from "
				+ "Empresa e");
		return query.list();
	}
	
	public List<Object[]> promocionesCompartidasPorUsuario(Session session,
			Usuario usuario){
		Query query = session.createQuery("select c.promocion from Comparte c,"
				+ "Usuario u"
				+ "inner join u.promocionesCompartidas"
				+ "where u.username = :username");
		query.setParameter("username", usuario.getUsername());
		return query.list();
	}
	
	
}
