package modelo;

public class Libro {
	
		private int id;
		private String titulo;
		private float precio;
		private int descuento;
	
	public Libro() {
		super();
		this.id = 0;
		this.titulo = "";
		this.precio=0;
		this.descuento=0;
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


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", descuento =" + descuento + "]";
	}

	
}
