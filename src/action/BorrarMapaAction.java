package action;

import java.util.Map;

import model.Mapas;

import org.apache.struts2.interceptor.ApplicationAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import dao.MapasDAO;

public class BorrarMapaAction extends ActionSupport implements ApplicationAware {
	private static final long serialVersionUID = 123L;
	private Map<String, Object> mapApp;
	private int idMapa;
	
	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}

	@Override
	public void setApplication(Map<String, Object> map) {
		mapApp = map;
	}

	public String execute() {
		SessionFactory factory = (SessionFactory)mapApp.get("hibernate");
		Session session = factory.openSession();
		String resul = Action.INPUT;
		
		try {
			Mapas m = MapasDAO.read(new Mapas(idMapa),session);
			if(m != null) {
				MapasDAO.delete(m,session);
				resul = Action.SUCCESS;
			}
		} catch(HibernateException he) {
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
