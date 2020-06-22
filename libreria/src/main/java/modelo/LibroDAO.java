package modelo;

import java.util.ArrayList;



public interface LibroDAO extends CRUDAble<Libro> {

	
		
		
		ArrayList<Libro> getAllByNombre( String titulo );
		

		
		
	}


