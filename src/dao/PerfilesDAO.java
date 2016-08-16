package dao;

import java.util.List;

import model.Perfiles;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PerfilesDAO {
	
	public static void create(Perfiles perfil, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.save(perfil);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static Perfiles read(Perfiles perfil, Session session) throws HibernateException {
		return (Perfiles)session.get(Perfiles.class,perfil.getIdPerfil());
	}
	
	@SuppressWarnings("unchecked")
	public static List<Perfiles> readId(Perfiles perfil, Session session) throws HibernateException {
		Query q = session.createQuery("from Perfiles p where p.idPerfil = :idPerfil");
		
		return q.setInteger("idPerfil",perfil.getIdPerfil()).list();
	}
	
	public static void update(Perfiles perfil, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.update(perfil);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static void delete(Perfiles perfil, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(perfil);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Perfiles> listar(Session session) {
		Query q = session.createQuery("from Perfiles");
		
		return q.list();
	}
}
