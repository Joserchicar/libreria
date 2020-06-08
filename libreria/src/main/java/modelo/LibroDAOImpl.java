package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import modelo.Libro;
import modelo.conexion.ConnectionManager;

public class LibroDAOImpl implements LibroDAO {

	private static LibroDAOImpl INSTANCE = null;

	private LibroDAOImpl() {
		super();
	}

	public static synchronized LibroDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroDAOImpl();
		}

		return INSTANCE;
	}

	@Override
	public ArrayList<Libro> getAll() throws Exception {
		ArrayList<Libro> registros = new ArrayList<Libro>();

		// Execute Query
		String sql = "SELECT id, titulo FROM libro ORDER BY id DESC;";
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {
			while (rs.next()) {
				// recuperamos columnas del rs(resultSet)
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");

				// Creamos el objeto con lo obtenido en rs

				Libro libro = new Libro();
				libro.setId(id);
				libro.setTitulo(titulo);

				// guardar en lista
				registros.add(libro);

			} // while

		} catch (Exception e) {

			e.printStackTrace();

		}

		return registros;
	}

	@Override
	public Libro getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro insert(Libro p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro update(Libro p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Libro> getAllByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}
	