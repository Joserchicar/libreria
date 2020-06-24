package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Genero;
import modelo.GeneroDAO;
import modelo.conexion.ConnectionManager;

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

	@Override
	public ArrayList<Genero> getAll() {
		
		ArrayList<Genero> registros = new ArrayList<Genero>();

		try ( Connection conexion = ConnectionManager.getConnection();
			  PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
			  ResultSet rs = pst.executeQuery();
		) {

			while (rs.next()) {
				registros.add(mapper(rs));
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;

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
		g.setGenero (rs.getString("genero"));
		return g;
	}

}
