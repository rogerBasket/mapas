package dao;

import java.util.List;

import model.Paginas;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaginasDAO {
	
	public static void create(Paginas pagina, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.save(pagina);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static Paginas read(Paginas pagina, Session session) throws HibernateException {
		return (Paginas)session.get(Paginas.class,pagina.getIdPagina());
	}
	
	public static void update(Paginas pagina, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.update(pagina);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static void delete(Paginas pagina, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(pagina);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Paginas> listar(Session session) {
		Query q = session.createQuery("from Paginas");
		
		return q.list();
	}
}
