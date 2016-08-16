package interceptor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import model.Paginas;
import model.Usuarios;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidacionInterceptor implements Serializable, Interceptor {
	private static final long serialVersionUID = 123L;
	private String publicos;
	private List<String> lista;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		lista = Arrays.asList(publicos.split(","));
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String action = (String)ActionContext.getContext().get(ActionContext.ACTION_NAME);
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		
		if(lista.contains(action))
			return arg0.invoke();
		else if(session.containsKey("usuario")) {
			Usuarios u = (Usuarios)session.get("usuario");
			List<Paginas> l = u.getPerfil().getPaginas();
			
			for(Paginas p: l)
				if(p.getNombre().equals(action))
					return arg0.invoke();
		}
		
		return Action.LOGIN;
	}

	public void setPublicos(String publicos) {
		this.publicos = publicos;
	}
}
