package modelo.modeloDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.conexion.ConnectionManager;
import modelo.modeloDAO.GeneroDAO;
import modelo.pojo.Genero;
import modelo.pojo.Libro;

public class GeneroDAOImpl implements GeneroDAO {

	private static GeneroDAOImpl INSTANCE = null;

	private GeneroDAOImpl() {
		super();
	}

	public static synchronized GeneroDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new GeneroDAOImpl();
		}

		return INSTANCE;
	}

	// excuteQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT id, genero FROM genero ORDER BY genero ASC; ";
	private final String SQL_GET_ALL_LIBROS = " SELECT " + "g.id'generoId'," + " g.genero'genero'," + "l.id 'idLibro',"
			+ " l.titulo'tituloLibro' " + "FROM  genero g,libro l " + " where l.genero =g.id "
			+ "ORDER BY g.genero ASC; ";

	@Override
	public ArrayList<Genero> getAll() {

		ArrayList<Genero> registros = new ArrayList<Genero>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				registros.add(mapper(rs));
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;

	}

	@Override
	public ArrayList<Genero> getAllLibros() {

		// ArrayList<Genero> registros = new ArrayList<Genero>();
		// La clave va a ser Integer, con el id de Genero
		HashMap<Integer, Genero> registros = new HashMap<Integer, Genero>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL_LIBROS);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				int idGenero = rs.getInt("generoId");
				Genero g = registros.get("generoId");
				if (g == null) {
					g = new Genero();
					g.setId(idGenero);
					g.setGenero(rs.getString("genero"));

					Libro l = new Libro();
					l.setId(rs.getInt("idLibro"));

					// Se recuperamn los libros y se añade uno mas dentro de la categoría.
					g.getLibros().add(l);

					// Guardar en el HashMap la categoría .

					registros.put(idGenero, g);
				}

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Genero>(registros.values());

	}

	// TODO implementar estos metodos cuando necesitemos

	@Override
	public Genero getById(int id) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Genero delete(int id) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Genero insert(Genero pojo) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Genero update(Genero pojo) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	private Genero mapper(ResultSet rs) throws SQLException {
		Genero g = new Genero();
		g.setId(rs.getInt("id"));
		g.setGenero(rs.getString("genero"));
		return g;
	}

}
