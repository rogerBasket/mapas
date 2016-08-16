package dao;

import java.util.List;

import model.Usuarios;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuariosDAO {
	
	public static void create(Usuarios usuario, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.save(usuario);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static Usuarios read(Usuarios usuario, Session session) throws HibernateException {
		return (Usuarios)session.get(Usuarios.class,usuario.getIdUsuario());
	}
	
	@SuppressWarnings("unchecked")
	public static List<Usuarios> readData(Usuarios usuario, Session session) throws HibernateException {
		Query q = session.createQuery("from Usuarios u where u.user = :user");
		
		return q.setString("user",usuario.getUser()).list();
	}
	
	public static void update(Usuarios usuario, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.update(usuario);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public static void delete(Usuarios usuario, Session session) throws HibernateException {
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(usuario);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Usuarios> listar(Session session) {
		Query q = session.createQuery("from Usuarios");
		
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Usuarios> listarByPerfil(int perfil, Session session) {
		Query q = session.createQuery("from Usuarios u where u.perfil = :perfil");
		
		return q.setInteger("perfil",perfil).list();
	}
}
