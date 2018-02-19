package modelo;

public class Asignatura {
	private int id;
	private String nombre;
	private int horas;

	public Asignatura(int id, String nombre, int horas) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}

	public Asignatura() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
}
