package vista;

import java.util.Iterator;

import modelo.*;

public class VistaMatricula {
	public void listarMatriculas() {
		MatriculaModelo mm = new MatriculaModelo();
		AlumnoModelo alm = new AlumnoModelo();
		AsignaturaModelo asm = new AsignaturaModelo();
		Iterator<Matricula> i = mm.selectAll().iterator();
		while (i.hasNext()) {
			Matricula matricula = i.next();
			Alumno alumno = alm.selectPorId(matricula.getId_alumno());
			System.out.println("Info Alumno:");
			listarAlumno(alumno);
			Asignatura asignatura = asm.selectPorId(matricula.getId_asignatura());
			listarAsignatura(asignatura);
		}
	}

	private void listarAlumno(Alumno alumno) {
		System.out.println("ID : " + alumno.getId() + "\nDNI : " + alumno.getDni() + "\nNombre : " + alumno.getNombre()
				+ "\nEmail : " + alumno.getEmail());
	}

	private void listarAsignatura(Asignatura asignatura) {
		System.out.println("ID : " + asignatura.getId() + "\nNombre : " + asignatura.getNombre() + "\nHoras : "
				+ asignatura.getHoras());
	}
}
