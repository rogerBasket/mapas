package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SalirAction extends ActionSupport {
	private static final long serialVersionUID = 123L;

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);
		
		if(session != null)
			session.invalidate();
		
		return Action.SUCCESS;
	}
}
