package modelo.modeloDAO;

import modelo.pojo.CRUDAble;
import modelo.pojo.Usuario;

public interface UsuarioDAO extends CRUDAble<Usuario> {

	
	/**
	 * Busca si existe el usuario en la base datsos
	 * @param nombre
	 * @param contrasenia
	 * @return Usuario con datos si lo encuentra, si no existe retorna null
	 */
	Usuario existe ( String nombre, String contrasenia ); 	
	
	
	
	
	
	
	
}
