package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import modelo.Genero;
import modelo.GeneroDAOImpl;
import modelo.Libro;
import modelo.LibroDAOImpl;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static LibroDAOImpl daoLibro=LibroDAOImpl.getInstance();
	private static GeneroDAOImpl daoGenero = GeneroDAOImpl.getInstance();

	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();
	
	

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
			
request.setAttribute("genero", daoGenero.getAll());
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
		Libro libro = new Libro();

		try {

			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String titulo = request.getParameter("titulo");
			String generoId= request.getParameter("genero_id");
			
			int id = Integer.parseInt(idParametro);
			int idGenero= Integer.parseInt(generoId);
			
			// DAO
			LibroDAOImpl dao = LibroDAOImpl.getInstance();

			//  parametros
			
			libro.setId(id);
			libro.setTitulo(titulo);
			
			Genero g=new Genero();
			g.setId(idGenero);
			libro.setGenero(g);
			
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);

			if (violations.isEmpty() ) {
				// vuelve al inicio y vuelve para listar los libros (redirecciona)

				if (id == 0) {

					daoLibro.insert(libro);

					request.getSession().setAttribute("mensaje", "Libro registrado con exito");
					request.setAttribute("libro", libro);
				} else {
					daoLibro.update(libro);

					// ir a la vista del registro de libros
					request.setAttribute("libro", libro);

					// request.setAttribute("mensaje", "El libro ya existe");

				} // if
			} else {
				request.setAttribute("mensaje", "El titulo debe tener entre 2 y 100 caracteres");
			}
		} catch (SQLException e) {
			request.setAttribute("mensaje", " Lo sentimos pero ya existe ese titulo. Introduzca otro ");
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", " Lo sentimos pero hemos tenido una Excepcion " + e.getMessage());
			e.printStackTrace();
		} finally {
			
			//Enviar datos a la vista
			request.setAttribute("libro", libro);
			request.setAttribute("generos", daoGenero.getAll());

			// ir a la nueva vista o jsp

			request.getRequestDispatcher("registro.jsp").forward(request, response);
		} // trycatch

	}

}// dopost
