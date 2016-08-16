package listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		SessionFactory factory = (SessionFactory)arg0.getServletContext().getAttribute("hibernate");
		factory.close();
	}

	@Override
	@SuppressWarnings("deprecation")
	public void contextInitialized(ServletContextEvent arg0) {
		URL url = this.getClass().getResource("/hibernate.cfg.xml");
		Configuration config = new Configuration().configure(url);
		SessionFactory factory = config.buildSessionFactory();
		
		arg0.getServletContext().setAttribute("hibernate",factory);
	}
}
