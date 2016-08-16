package action;

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
import com.opensymphony.xwork2.ModelDriven;

import dao.MapasDAO;

public class GuardarMapaAction extends ActionSupport implements ModelDriven<Mapas>, SessionAware, ApplicationAware {
	private static final long serialVersionUID = 123L;
	private Mapas mapa = new Mapas();
	private Map<String, Object> mapApp;
	private Map<String, Object> mapSession;
	
	@Override
	public Mapas getModel() {
		return mapa;
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
			mapa.setUsuario(u);
			MapasDAO.create(mapa,session);
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
