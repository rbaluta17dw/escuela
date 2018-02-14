package biblioteca;

import java.util.Date;

public class Prestamo {
	private int id;
	private int idUsuario;
	private int idLibro;
	private Date fechaPrestamo;
	private Date fechaLimite;
	private boolean entregado;

	public Prestamo(int id, int idUsuario, int idLibro, Date fechaPrestamo, Date fechaLimite, boolean entregado) {
		this.idUsuario = idUsuario;
		this.idLibro = idLibro;
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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
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
