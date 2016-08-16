package action;

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

import dao.UsuariosDAO;

public class ListarUsuariosAction extends ActionSupport implements SessionAware, ApplicationAware {
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
			List<Usuarios> l = UsuariosDAO.listarByPerfil(2,session);
			mapSession.put("listaUsuarios",l);
			resul = Action.SUCCESS;
		} catch(HibernateException he) {
			he.printStackTrace();
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
