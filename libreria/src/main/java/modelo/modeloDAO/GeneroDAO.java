package modelo;

import java.util.ArrayList;

public interface GeneroDAO extends CRUDAble<Genero> {

	public ArrayList<Genero> getAll();
	
}

