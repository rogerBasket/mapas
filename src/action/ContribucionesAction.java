package action;

import java.util.List;
import java.util.Map;

import model.Mapas;
import model.Usuarios;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import dao.MapasDAO;

public class ContribucionesAction extends ActionSupport implements SessionAware, ApplicationAware {
	private static final long serialVersionUID = 123L;
	private Map<String, Object> mapApp;
	private Map<String, Object> mapSession;
	
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
			Usuarios usuario = (Usuarios)mapSession.get("usuario");
			List<Mapas> l = MapasDAO.listarByNotUsuario(usuario,session);
			mapSession.put("listaMapas",l);
			resul = Action.SUCCESS;
		} catch(HibernateException he) {
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
