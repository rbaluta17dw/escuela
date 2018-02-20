package biblioteca;

import java.util.Date;

public class Prestamo {
	private int id;
	private Usuario usuario;
	private Libro libro;
	private Date fechaPrestamo;
	private Date fechaLimite;
	private boolean entregado;

	public Prestamo(int id, Usuario usuario, Libro libro, Date fechaPrestamo, Date fechaLimite, boolean entregado) {
		this.usuario = usuario;
		this.libro = libro;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaLimite = fechaLimite;
	}

	public Prestamo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

}
