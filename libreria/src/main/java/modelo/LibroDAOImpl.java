package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String sql = "SELECT id, titulo FROM libro ORDER BY id DESC;";
		Libro registro = new Libro();
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(sql);

		) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				registro.setId(rs.getInt("id"));
				registro.setTitulo(rs.getString("titulo"));

			} else {
				throw new Exception("no se encuentra registro con id= " + id);

			}

		}
		return registro;
	}

	@Override
	public Libro delete(int id) throws Exception {
		
	 String sql = " DELETE FROM libro WHERE id = ? ; ";
		
		// conseguir el libro antes de Eliminar
		Libro registro =  getById(id);
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(sql);				
				
			){
			
			
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			
			if ( affectedRows != 1 ) {
				throw new Exception("No se puedo eliminar el registro id = " + id);				
			}
			
			
		}// try		
		return registro;
		
	
	}

	@Override
	public Libro insert(Libro libro) throws Exception {

		ArrayList<Libro> registros = new ArrayList<Libro>();

		// Execute Query
		String sql = " INSERT INTO libro (titulo) VALUES ( ? ); ";

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, libro.getTitulo());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {

				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						// recuperamos columnas del rs(resultSet)
						int id = rsKeys.getInt("id");
						String titulo = rsKeys.getString("titulo");

						// Creamos el objeto con lo obtenido en rs

						libro = new Libro();
						libro.setId(id);
						libro.setTitulo(titulo);

						// guardar en lista
						registros.add(libro);

					}
				}

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return libro;
	}

	@Override
	public Libro update(Libro libro) throws Exception {

		ArrayList<Libro> registros = new ArrayList<Libro>();

		// execute query

		String sql = "UPDATE libro SET nombre=? WHERE id=?; ";

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(sql);

		) {

			pst.setInt(1, libro.getId());
			pst.setString(2, libro.getTitulo());

			int affectedRows = pst.executeUpdate();
			

			if (affectedRows == 1) {
				
				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						int id = rsKeys.getInt(1);
						String titulo=rsKeys.getString(2);
						libro.setId(id);
						libro.setTitulo(titulo);
					}

				}

			}else {
				
				throw new Exception("No se ha podido guardar el registro " + libro );
			}

		} catch (SQLException e) {
			throw new Exception(" El nombre" + libro.getTitulo() + " del libro ya existe");
		}

		return libro;
	}

	@Override
	public ArrayList<Libro> getAllByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}
