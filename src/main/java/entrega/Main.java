package main.java.entrega;

import java.util.ArrayList;
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
		
		testEverything();
	}
	
	public static void testEverything() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Usuario user = new Usuario();
			user.setUsername("prengifo");
			
			Categoria categoria1 = new Categoria();
			categoria1.setNombre("software");
			Categoria categoria2 = new Categoria();
			categoria2.setNombre("desarrollo");
			categoria2.setCategoriaPadre(categoria1);
			List<Categoria> hijos = new ArrayList<>();
			hijos.add(categoria2);
			categoria1.setSubcategoria(hijos);
			
			Categoria categoria3 = new Categoria();
			categoria3.setNombre("cafes");
			
			TarjetaDeCredito tarjeta = new TarjetaDeCredito();
			tarjeta.setNombre("patrick skjdksjd");
			tarjeta.setNumeroTarjeta("1212 767676 2525 6990");
			tarjeta.setFechaDeVencimiento("12/12/12");
			tarjeta.setCodigoSeguridad(122);
			
			tarjeta.setUsuario(user);
			List<TarjetaDeCredito> tarjetasDeCredito = new ArrayList<>();
			tarjetasDeCredito.add(tarjeta);
			user.setTarjetasDeCredito(tarjetasDeCredito);
			
			Ciudad city = new Ciudad();
			city.id = new CiudadId();
			city.id.setNombre("Caracas");
			city.id.setRadio("20");
			
			Ubicacion ubicacion1 = new Ubicacion();
			ubicacion1.setCoordenadas("123456, -4567");
			Ubicacion ubicacion2 = new Ubicacion();
			ubicacion2.setCoordenadas("7286874, -72456794379");
			
			List<Ubicacion> ubicaciones = new ArrayList<>();
			ubicaciones.add(ubicacion1);
			ubicaciones.add(ubicacion2);
			city.setUbicaciones(ubicaciones);
			
			List<Ciudad> ciudadesPreferidas = new ArrayList<>();
			ciudadesPreferidas.add(city);
			user.setCiudadesPreferidas(ciudadesPreferidas);
			
			DineroPromocion dinero = new DineroPromocion();
			dinero.setCantidad((float) 300.00);
			dinero.setUsername("prengifo");
			user.setSaldoPromocion(dinero);
			
			Empresa empresa1 = new Empresa();
			empresa1.setNombre("damper");
			empresa1.setCorreoElectronico("portucatire@gmail.com");
			
			Empresa empresa2 = new Empresa();
			empresa2.setNombre("talPor");
			empresa2.setCorreoElectronico("contacto@talpor.com");
			
			Promocion promocion = new Promocion();
			promocion.setNombre("Cafes en Damper");
			promocion.setEmpresa(empresa1);
			promocion.setCategoria(categoria3);
			
			List<Promocion> promociones = new ArrayList<>();
			promociones.add(promocion);
			categoria3.setPromociones(promociones);
			
			Promocion promocion2 = new Promocion();
			promocion2.setNombre("desarrollos web gratis");
			promocion2.setEmpresa(empresa2);
			promocion2.setUbicaciones(ubicaciones);
			promocion2.setCategoria(categoria2);
			
			Promocion promocion3 = new Promocion();
			promocion3.setNombre("desarollo de aplicaciones moviles con descuento");
			promocion3.setEmpresa(empresa2);
			promocion3.setUbicaciones(ubicaciones);
			promocion3.setCategoria(categoria2);
			
			List<Promocion> promociones1 = new ArrayList<>();
			promociones1.add(promocion2);
			promociones1.add(promocion3);
			categoria2.setPromociones(promociones1);
			
			RedSocial redSocial1 = new RedSocial();
			redSocial1.setServicio("twitter");
			redSocial1.setUrl("twitter.com/pattsammy");
			redSocial1.setUsuario(user);
			List<RedSocial> redesSociales = new ArrayList<>();
			redesSociales.add(redSocial1);
			user.setRedesSociales(redesSociales);
			
			RedSocial redSocial2 = new RedSocial();
			redSocial2.setServicio("twitter");
			redSocial2.setUrl("twitter.com/talpor");
			redSocial2.setPromocion(promocion2);
			List<RedSocial> redesSociales1 = new ArrayList<>();
			redesSociales.add(redSocial2);
			promocion2.setRedesSociales(redesSociales1);
			promocion3.setRedesSociales(redesSociales1);
			
			Compra compra1 = new Compra();
			compra1.setPk(new CompraId());
			compra1.setUsuario(user);
			compra1.setPromocion(promocion3);
			compra1.setDestinatario("danielar92@gmail.com");
			compra1.setMetodoPago("TDC");
			compra1.setCompartido(false);
			
			Compra compra2 = new Compra();
			compra2.setPk(new CompraId());
			compra2.setUsuario(user);
			compra2.setPromocion(promocion2);
			compra2.setDestinatario("david@gmail.com");
			compra2.setMetodoPago("TDC");
			compra2.setCompartido(false);
			
			Comparte comparte1 = new Comparte();
			comparte1.setPk(new ComparteId());
			comparte1.setPromocion(promocion);
			comparte1.setUsuario(user);
			List<String> destinatarios = new ArrayList<>();
			destinatarios.add("danielar92@gmail.com");
			destinatarios.add("david@gmail.com");
			destinatarios.add("volta@gmail.com");
			comparte1.setDestinatarios(destinatarios);
			
			session.save(city);
			session.save(categoria1);
			session.save(categoria2);
			session.save(categoria3);
			session.save(ubicacion1);
			session.save(ubicacion2);
			session.save(dinero);
			session.save(user);
			session.save(tarjeta);
			session.save(empresa1);
			session.save(empresa2);
			session.save(promocion);
			session.save(promocion2);
			session.save(promocion3);
			session.save(redSocial1);
			session.save(redSocial2);
			session.save(compra1);
			session.save(compra2);
			session.save(comparte1);
			
			
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
