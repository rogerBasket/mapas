package action;

import java.util.Map;

import model.Usuarios;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UsuariosDAO;

public class PerfilAction extends ActionSupport implements ModelDriven<Usuarios>, SessionAware, ApplicationAware {
	private static final long serialVersionUID = 123L;
	private Usuarios usuario = new Usuarios();
	private Map<String, Object> mapApp;
	private Map<String, Object> mapSession;
	private String boton;
	
	public String getBoton() {
		return boton;
	}

	public void setBoton(String boton) {
		this.boton = boton;
	}

	@Override
	public Usuarios getModel() {
		return usuario;
	}
	
	@Override
	public void setApplication(Map<String, Object> map) {
		mapApp = map;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		mapSession = map;
	}

	public String execute() {
		SessionFactory factory = (SessionFactory)mapApp.get("hibernate");
		Session session = factory.openSession();
		String resul = Action.INPUT;
		
		try {
			Usuarios u = (Usuarios)mapSession.get("usuario");
			if(boton.equals("Editar")) {
				usuario.setIdUsuario(u.getIdUsuario());
				usuario.setPerfil(u.getPerfil());
				UsuariosDAO.update(usuario,session);
				mapSession.put("usuario",usuario);
				resul = "usuario";
			} else if(boton.equals("Eliminar")) {
				UsuariosDAO.delete(UsuariosDAO.read(u,session),session);
				resul = "salir";
			}
		} catch(HibernateException he) {
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
