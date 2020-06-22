package modelo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Libro {
	
		private int id;
		
		@NotBlank
		@Size( min = 3, max = 100, message = "La longtitud de ser entre 3 y 100 caracteres")
		private String titulo;
		
		
		private Genero genero;
		

	
	public Libro() {
		super();
		this.id = 0;
		this.titulo = "";
		this.genero=new Genero();
		
	}

	public Libro(String titulo) {
		this();
		this.titulo = titulo;
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo= titulo;
	}

	

	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", genero=" + genero + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	

	
}
