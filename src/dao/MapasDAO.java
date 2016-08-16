package dao;

import java.util.List;

import model.Mapas;
import model.Usuarios;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MapasDAO {
	public static void create(Mapas mapa, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.save(mapa);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static Mapas read(Mapas mapa, Session session) throws HibernateException {
		return (Mapas)session.get(Mapas.class,mapa.getIdMapa());
	}
	
	public static void update(Mapas mapa, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.update(mapa);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static void delete(Mapas mapa, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(mapa);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Mapas> listar(Session session) {
		Query q = session.createQuery("from Mapas");
		
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Mapas> listarByUsuario(Usuarios usuario, Session session) {
		Query q = session.createQuery("from Mapas m where m.usuario = :usuario");
		
		return q.setParameter("usuario",usuario).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Mapas> listarByNotUsuario(Usuarios usuario, Session session) {
		Query q = session.createQuery("from Mapas m where m.usuario != :usuario");
		
		return q.setParameter("usuario",usuario).list();
	}
}
