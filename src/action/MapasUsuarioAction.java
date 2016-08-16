package action;

import java.util.List;
import java.util.Map;

import model.Mapas;
import model.Usuarios;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import dao.MapasDAO;

public class MapasUsuarioAction extends ActionSupport implements RequestAware, ApplicationAware {
	private static final long serialVersionUID = 123L;
	private Map<String, Object> mapReq;
	private Map<String, Object> mapApp;
	private int idUsuario;
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public void setApplication(Map<String, Object> map) {
		mapApp = map;
	}

	@Override
	public void setRequest(Map<String, Object> map) {
		mapReq = map;
	}

	public String execute() {
		SessionFactory factory = (SessionFactory)mapApp.get("hibernate");
		Session session = factory.openSession();
		String resul = Action.INPUT;
		
		try {
			List<Mapas> mapas = MapasDAO.listarByUsuario(new Usuarios(idUsuario),session);
			mapReq.put("listaMapas",mapas);
			resul = Action.SUCCESS;
		} catch(HibernateException he) {
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
