package action;

import java.util.Map;

import model.Usuarios;

import org.apache.struts2.interceptor.ApplicationAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import dao.UsuariosDAO;

public class BorrarUsuarioAction extends ActionSupport implements ApplicationAware {
	private static final long serialVersionUID = 123L;
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

	public String execute() {
		SessionFactory factory = (SessionFactory)mapApp.get("hibernate");
		Session session = factory.openSession();
		String resul = Action.INPUT;
		
		try {
			Usuarios u = UsuariosDAO.read(new Usuarios(idUsuario),session);
			if(u != null) {
				UsuariosDAO.delete(u,session);
				resul = Action.SUCCESS;
			}
		} catch(HibernateException he) {
			he.printStackTrace();
			resul = Action.ERROR;
		} finally {
			session.close();
		}
		
		return resul;
	}
}
