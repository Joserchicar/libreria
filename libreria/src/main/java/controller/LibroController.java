package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.LibroDAOImpl;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/inicio")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibroDAOImpl dao = LibroDAOImpl.getInstance();

		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			libros = dao.getAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("libros", libros);

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Libro libro = new Libro();
		LibroDAOImpl dao = new LibroDAOImpl();

		try {

			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String titulo = request.getParameter("titulo");
			String precio = request.getParameter("precio");
			String descuentoParam = request.getParameter("descuento");

			int id = Integer.parseInt(idParametro);
			float precioFloat = Float.parseFloat(precio);
			int descuento = Integer.parseInt(descuento);

			libro.setId(id);
			libro.setTitulo(titulo);
			;
			libro.setPrecio(precioFloat);
			libro.setDescuento(descuento);

			if (id == 0) {
				dao.insert(libro);

			} else {
				dao.update(libro);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// enviar datos a la vista

			request.setAttribute("libro", libro);

			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario.jsp").forward(request, response);

		}
	}
}