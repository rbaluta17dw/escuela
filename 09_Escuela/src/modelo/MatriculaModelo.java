package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {
	public ArrayList<Matricula> selectAll() {
		ArrayList<Matricula> listaMatriculas = new ArrayList<Matricula>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELEC * FROM matriculas");
			while (rs.next()) {
				Matricula m = new Matricula(rs.getInt("id_alumno"), rs.getInt("id_asignatura"), rs.getDate("fecha"));
				listaMatriculas.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaMatriculas;
	}
}
