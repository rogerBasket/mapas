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

public class ListarMapasAction extends ActionSupport implements SessionAware, ApplicationAware {
	private static final long serialVersionUID = 123L;
	private Map<String, Object> mapSession;
	private Map<String, Object> mapApp;
	
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
		String resul = Action.SUCCESS;
		
		try {
			Usuarios u = (Usuarios)mapSession.get("usuario");
			List<Mapas> l = MapasDAO.listarByUsuario(u,session);
			mapSession.put("listaMapas",l);
		} catch(HibernateException he) {
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
