package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class VistaMatricula {

	static final int MOSTRAR_MATRICULAS = 1;
	static final int ALUMNOS_MATRICULAS = 2;
	static final int SALIR = 0;

	public void menuMatriculas() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("--Menu de matriculas--");
			System.out.println(MOSTRAR_MATRICULAS + " - listar todas");
			System.out.println(ALUMNOS_MATRICULAS + " - alumnos con matriculas");
			System.out.println(SALIR + " - salir");
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case MOSTRAR_MATRICULAS:
				MatriculaModelo matriculaModelo = new MatriculaModelo();
				ArrayList<Matricula> matriculas = matriculaModelo.selectAll();
				this.MostrarMatriculas(matriculas);

				break;
			case ALUMNOS_MATRICULAS:
				VistaAlumno vistaAlumno = new VistaAlumno();
				vistaAlumno.menuAlumnos();
				break;

			default:
				break;
			}

		} while (opcion != SALIR);

	}

	public void MostrarMatriculas(ArrayList<Matricula> matriculas) {
		Iterator<Matricula> i = matriculas.iterator();
		while (i.hasNext()) {
			Matricula matricula = i.next();
			mostrarMatricula(matricula);
		}
	}

	private void mostrarMatricula(Matricula matricula) {
		System.out.println("INFO ALUMNO : " + "\nNombre : " + matricula.getAlumno().getNombre() + "\nDNI : "
				+ matricula.getAlumno().getDni() + "\nINFO ASIGNATURA : " + "\nNombre : "
				+ matricula.getAsignatura().getNombre() + "\nHoras : " + matricula.getAsignatura().getHoras() + "\n");
	}
}
