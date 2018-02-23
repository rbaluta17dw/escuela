package modelo;

import java.util.ArrayList;

public class Alumno {
	private int id;
	private String dni;
	private String nombre;
	private String email;
	private ArrayList<Matricula> matriculas;
	private ArrayList<Asignatura> asiganaturas;

	public Alumno(int id, String dni, String nombre, String email) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	public Alumno() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public ArrayList<Asignatura> getAsiganaturas() {
		return asiganaturas;
	}

	public void setAsiganaturas(ArrayList<Asignatura> asiganaturas) {
		this.asiganaturas = asiganaturas;
	}
}
