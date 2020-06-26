package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.Alerta;
import modelo.modeloDAOImpl.GeneroDAOImpl;
import modelo.pojo.Genero;

/**
 * Application Lifecycle Listener implementation class InicioAppListenner
 *
 */
@WebListener
public class InicioAppListener implements ServletContextListener {

	static private final GeneroDAOImpl generoDAO = GeneroDAOImpl.getInstance();

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// cuando paramos la App
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// cuando ejecutamos la App en el Servidor, al arrancar la 1º vez
		System.out.println("Estamos arrancado la App, y soy un evento");

		// Este contexto es para toda la Aplicacion y es accesible desde cualñquier JSP
		// o Servlet
		ServletContext contextoAplicacion = sce.getServletContext();

		try {

			contextoAplicacion.setAttribute("categorias", generoDAO.getAll());

		} catch (Exception e) {

			e.printStackTrace();

			contextoAplicacion.setAttribute("alerta", new Alerta("danger", "Tenemos un problema sin determinar"));
		}

	}

}
