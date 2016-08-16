package action;

import java.io.Serializable;
import java.util.List;
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

public class LoginAction extends ActionSupport implements Serializable, ModelDriven<Usuarios>, SessionAware, ApplicationAware {
	private static final long serialVersionUID = 123L;
	private Usuarios usuario = new Usuarios();
	private Map<String, Object> mapSession;
	private Map<String, Object> mapApp;
	
	public Usuarios getModel() {
		return usuario;
	}
	
	public void setSession(Map<String, Object> map) {
		this.mapSession = map;
	}
	
	public void setApplication(Map<String, Object> map) {
		this.mapApp = map;
	}
	
	public String execute() {
		SessionFactory factory = (SessionFactory)mapApp.get("hibernate");
		Session session = factory.openSession();
		String resul = Action.INPUT;
		
		try {
			List<Usuarios> l = UsuariosDAO.readData(usuario,session);
			if(l.size() == 1) {
				Usuarios u = l.get(0);
				if(u.getUser().equals(usuario.getUser()) && u.getPass().equals(usuario.getPass())) {
					mapSession.put("usuario",u);
					if(u.getPerfil().getDescripcion().equals("administrador"))
						resul = "admin";
					else
						resul = "usuario";
				}
			}
		} catch(HibernateException he) {
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
