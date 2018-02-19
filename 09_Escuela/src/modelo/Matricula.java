package modelo;

import java.util.Date;

public class Matricula {
	private int id_alumno;
	private int id_asignatura;
	private Date fecha;

	public Matricula(int id_alumno, int id_asignatura, Date fecha) {
		this.id_alumno = id_alumno;
		this.id_asignatura = id_asignatura;
		this.fecha = fecha;
	}

	public Matricula() {

	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
