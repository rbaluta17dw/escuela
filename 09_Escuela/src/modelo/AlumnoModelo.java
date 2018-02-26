package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoModelo extends Conector {
	public ArrayList<Alumno> selectAll() {
		ArrayList<Alumno> ListaAlumnos = new ArrayList<Alumno>();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
			while (rs.next()) {
				Alumno a = new Alumno(rs.getInt("id"), rs.getString("dni"), rs.getString("nombre"),
						rs.getString("email"));
				ListaAlumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ListaAlumnos;

	}

	public Alumno selectPorId(int id) {
		Alumno alumno = null;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos WHERE id = ('" + id + "')");
			rs.next();
			alumno = new Alumno(rs.getInt("id"), rs.getString("dni"), rs.getString("nombre"), rs.getString("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alumno;
	}

	public ArrayList<Alumno> selectAllConMatriculas() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		MatriculaModelo matriculaModelo = new MatriculaModelo();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos");
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail("email");
				ArrayList<Matricula> matriculas = matriculaModelo.getMatriculasConAsignatura(alumno);
				alumno.setMatriculas(matriculas);

				alumnos.add(alumno);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alumnos;
	}

}
