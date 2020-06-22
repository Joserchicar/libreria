package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import modelo.conexion.ConnectionManager;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl INSTANCE = null;

	// executequery=>ResultSet
	static final String SQL_GET_ALL = " SELECT id,nombre, contrasenia FROM usuario ORDER BY id DESC LIMIT 500; ";
	static final String SQL_EXISTE = " SELECT id, nombre, contrasenia FROM usuario  WHERE nombre = ? AND contrasenia = ? ; ";

	private UsuarioDAOImpl() {
		super();
	}

	public static synchronized UsuarioDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}

		return INSTANCE;
	}

	@Override
	public ArrayList<Usuario> getAll() throws Exception {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			System.out.println("SQL= " + pst);

			while (rs.next()) {
				usuarios.add(mapper(rs));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario insert(Usuario p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario existe(String nombre, String contrasenia) {
	
		
		Usuario usuario = null;

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_EXISTE);

		) {

			pst.setString(1, nombre);
			pst.setString(2, contrasenia);

			
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {

					usuario = mapper(rs);
				}

			} // try

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}
	private Usuario mapper(ResultSet rs) throws SQLException {

		Usuario usuario = new Usuario();

		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setContrasenia(rs.getString("contrasenia"));
		
		

		return usuario;

	}
}
