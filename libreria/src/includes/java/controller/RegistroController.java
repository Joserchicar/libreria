package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.LibroDAOImpl;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String parametroId = request.getParameter("id");
			Libro libro = new Libro();

			if (parametroId != null) {

				int id = Integer.parseInt(parametroId);
				LibroDAOImpl dao = LibroDAOImpl.getInstance();
				libro = dao.getById(id);
			}
			request.setAttribute("libro", libro);

		} catch (Exception e) {
			request.setAttribute("danger", "Lo sentimos fallo en GET " + e.getMessage());
			e.printStackTrace();

		} finally {

			// ir a la nueva vista o jsp
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}

	}

	/**
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Crear objeto
			Libro libro=new Libro();
			
		try {

			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String titulo = request.getParameter("titulo");
			
			int id = Integer.parseInt(idParametro);
			
			// DAO
			LibroDAOImpl dao = LibroDAOImpl.getInstance();
			
			
			// Crear parametros
		
		    libro.setId(id);
			libro.setTitulo(titulo);

			

			if (titulo != null && titulo.length() > 2 && titulo.length() <= 100) {
				// vuelve al inicio y vuelve para listar los libros (redirecciona)

				if (id==0) {

					dao.insert(libro);
					request.setAttribute("libro", libro);
					request.getSession().setAttribute("mensaje", "Libro registrado con exito");
					//response.sendRedirect("registro.jsp");
					
				}  else {
					dao.update(libro);
					// ir a la vista del registro de libros
					request.setAttribute("libro", libro);
					request.setAttribute("mensaje", "El libro ya existe");
					//request.getRequestDispatcher("registro.jsp").forward(request, response);
				} // if
			}else {
				request.setAttribute("mensaje", "El titulo debe tener entre 2 y 100 caracteres");
			}
		} catch (Exception e) {
			request.setAttribute("mensaje", " Lo sentimos pero hemos tenido una Excepcion " + e.getMessage());
			e.printStackTrace()

		} finally {
			request.getRequestDispatcher("registro.jsp").forward(request, response);

		}// trycatch

		// ir a la nueva vista o jsp
		
	}

}// dopost
