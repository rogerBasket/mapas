package action;

import java.util.Map;

import model.Usuarios;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 123L;
	private Map<String, Object> mapSession;
	
	public void setSession(Map<String, Object> map) {
		mapSession = map;
	} 
	
	public String execute() {
		if(mapSession.containsKey("usuario")) {
			Usuarios usuario = (Usuarios)mapSession.get("usuario");
			if(usuario.getPerfil().getDescripcion().equals("administrador"))
				return "admin";
			else
				return "usuario";
		} else
			return "index";
	}
}
