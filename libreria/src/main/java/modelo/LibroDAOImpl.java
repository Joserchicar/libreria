package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Libro;
import modelo.conexion.ConnectionManager;

public class LibroDAOImpl implements LibroDAO {

	String sql = "SELECT id, titulo,precio,descuento FROM libro ORDER BY id DESC;";
	String SQL_INSERT = " INSERT INTO libro (nombre, precio , descuento ) VALUES ( ? , ?, ? ) ; ";

	private static LibroDAOImpl INSTANCE = null;

	public LibroDAOImpl() {
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

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {
			while (rs.next()) {
				// recuperamos columnas del rs(resultSet)
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				float precio = rs.getFloat("precio");
				int descuento = rs.getInt("descuento");

				// Creamos el objeto con lo obtenido en rs

				Libro libro = new Libro();
				libro.setId(id);
				libro.setTitulo(titulo);
				libro.setPrecio(precio);
				libro.setDescuento(descuento);

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
	public Libro insert(Libro l) throws Exception {
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		) {

			pst.setString(1, l.getTitulo());
			pst.setFloat(2, l.getPrecio());
			pst.setInt(3, l.getDescuento());

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {

				// conseguir el ID

				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						int id = rsKeys.getInt(1);
						l.setId(id);
					}

				}

			} else {
				throw new Exception("No se ha podido guardar el registro " + l);
			}

		}

		return l;
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
