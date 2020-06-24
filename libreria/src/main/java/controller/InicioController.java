package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GeneroDAOImpl;
import modelo.Libro;
import modelo.LibroDAO;
import modelo.LibroDAOImpl;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final LibroDAOImpl libroDAO = LibroDAOImpl.getInstance();
    private static final GeneroDAOImpl generoDAO= GeneroDAOImpl.getInstance();
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramIdGenero=request.getParameter("idGenero");
		ArrayList< Libro>libros= new ArrayList<Libro>();
		
		if (paramIdGenero != null) {
			
			int idGenero= Integer.parseInt(paramIdGenero);
			libros=libroDAO.getAllByGenero(idGenero,10 );	
			
		}else {
			libros=libroDAO.getLast(10);
				
		}
		request.setAttribute("libros",libros );
		request.setAttribute("generos", generoDAO.getAll());
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
