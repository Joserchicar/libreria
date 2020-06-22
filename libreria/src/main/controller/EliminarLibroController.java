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
 * Servlet implementation class EliminarLibroController
 */
@WebServlet("/EliminarLibro")
public class EliminarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoge parametro
		
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);
		
		// llamar modelo
		LibroDAOImpl dao = LibroDAOImpl.getInstance();
		String mensaje  = "";
		Libro libro = new Libro();
		
		try {
			libro= dao.delete(id);
			mensaje = "Eliminado " + libro.getTitulo();
			
		} catch (Exception e) {
			mensaje = "Error " + e.getMessage();
			e.printStackTrace();
		}finally {
			
			
			// guardar datos en session para el mensaje de la vista
						request.getSession().setAttribute("mensaje", "libro eliminado con exito" );
						
			// pedimos al cliente que realize una segunda REQUEST
			response.sendRedirect("inicio");
			
			
		}
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
