package biblioteca;

import java.util.ArrayList;

public class Libro {
	private int id;
	private String autor;
	private String titulo;
	private ArrayList<Prestamo> prestamos;

	public Libro() {

	}

	public Libro(int id, String autor, String titulo) {
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

}
