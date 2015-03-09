package main.java.entrega;

import java.util.ArrayList;
import java.util.List;

import main.java.entrega.models.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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

    public static void deleteTDC(String tarjetaDeCreditoId){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TarjetaDeCredito toDelete = (TarjetaDeCredito) session.load(TarjetaDeCredito.class, tarjetaDeCreditoId);
            if (toDelete != null){
                session.delete(toDelete);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	
	public static void testEverything() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			// Siguiendo los ejemplos de Moodle se hacen los insert
			
			Usuario user = new Usuario();
			user.setUsername("prengifo");
			
			Categoria categoria1 = new Categoria();
			categoria1.setNombre("software");
			Categoria categoria2 = new Categoria();
			categoria2.setNombre("desarrollo");
			categoria2.setCategoriaPadre(categoria1);
//			List<Categoria> hijos = new ArrayList<>();
//			hijos.add(categoria2);
//			categoria1.setSubcategoria(hijos);
			
			Categoria categoria3 = new Categoria();
			categoria3.setNombre("cafes");


			TarjetaDeCredito tarjeta = new TarjetaDeCredito("1212 767676 2525 6990", "patrick s rengifo m",
                    "12-2012", 122);

            TarjetaDeCredito tarjeta1 = new TarjetaDeCredito("374656559608168", "patrick s rengifo m",
                    "12-2016", 122);

			tarjeta.setUsuario(user);
            tarjeta1.setUsuario(user);
			List<TarjetaDeCredito> tarjetasDeCredito = new ArrayList<>();
			tarjetasDeCredito.add(tarjeta);
            tarjetasDeCredito.add(tarjeta1);
			user.setTarjetasDeCredito(tarjetasDeCredito);
			
			Ciudad city = new Ciudad();
			CiudadId cityid = new CiudadId();
			cityid.setNombre("Caracas");
			cityid.setRadio("20");
			city.setId(cityid);

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
			empresa1.setPromociones(promociones);
			
			Promocion promocion2 = new Promocion();
			promocion2.setNombre("desarrollos web gratis");
			promocion2.setEmpresa(empresa2);
			promocion2.setUbicaciones(ubicaciones);
			promocion2.setCategoria(categoria2);
			
			Promocion promocion3 = new Promocion();
			promocion3.setNombre("desarrollo de aplicaciones moviles con descuento");
			promocion3.setEmpresa(empresa2);
			promocion3.setUbicaciones(ubicaciones);
			promocion3.setCategoria(categoria2);
			
			List<Promocion> promociones1 = new ArrayList<>();
			promociones1.add(promocion2);
			promociones1.add(promocion3);
			categoria2.setPromociones(promociones1);
			empresa2.setPromociones(promociones1);
			
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
			
			// HQL is fully object-oriented and understands notions like inheritance,
			// polymorphism and association.
			// source http://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html/ch16.html
			
			System.out.println("Primera Consulta");
			promocionesPorNombre(session, "desarrollo");
			
			System.out.println();
			System.out.println("Segunda Consulta");
			promocionesPorEmpresa(session);
			
			System.out.println();
			System.out.println("Tercera Consulta");
			promocionesCompartidasPorUsuario(session, user);

			tx.commit();
            System.out.println("prueba de estados");
            tarjeta.doAction();
            tarjeta1.doAction();

		} catch (HibernateException e) {
			if (tx!= null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// Funciones para consulta
	
	public static void promocionesPorNombre(Session session, String consulta) {
		// faltaban los % en el parametro
		Query query = session.createQuery("from Promocion where nombre like :nombre");
		query.setParameter("nombre", "%"+ consulta + "%");
		List<Promocion> results = query.list();
        for (Promocion temp : results) {
            System.out.println(temp.getNombre());
        }
	}
	
	// simplificacion de los queries
	public static void promocionesPorEmpresa(Session session) {
		Query query = session.createQuery("from Empresa");
        List<Empresa> res1 = query.list();
        for (Empresa temp : res1) {
            System.out.println("----------------");
            System.out.println(temp.getNombre());
            System.out.println("Promociones");
            for (Promocion temp1 : temp.getPromociones()){
                System.out.println(temp1.getNombre());
            }
        }
	}
	
	public static void promocionesCompartidasPorUsuario(Session session,
			Usuario usuario){
		Query query = session.createQuery("from Comparte where username = :username");
		query.setParameter("username", usuario.getUsername());
		List<Comparte> res2 = query.list();
        for (Comparte temp : res2) {
            System.out.print("Promociones compartidas por ");
            System.out.println(temp.getUsuario().getUsername());
            System.out.println("----------------");
            System.out.println(temp.getPromocion().getNombre());
        }
	}
	
	
}
