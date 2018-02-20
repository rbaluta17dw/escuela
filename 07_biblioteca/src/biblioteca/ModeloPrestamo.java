package biblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ModeloPrestamo extends Conector {
	public void insert(Prestamo prestamo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement(
					"INSERT INTO prestamo (id_libro, id_usuario, fecha_prestamo, fecha_limite, entregado) values (?,?,?,?,?)");
			pst.setInt(1, prestamo.getLibro().getId());
			pst.setInt(2, prestamo.getUsuario().getId());
			pst.setDate(3, dateToSql(prestamo.getFechaPrestamo()));
			pst.setDate(4, dateToSql(prestamo.getFechaLimite()));
			pst.setBoolean(5, prestamo.isEntregado());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Prestamo prestamo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE prestamo SET entregado = 1 WHERE id = ?");
			pst.setInt(1, prestamo.getId());
			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			Statement st = conexion.createStatement();
			st.executeQuery("DELETE FROM prestamo WHERE id = ('" + id + "')");
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Prestamo> selectAll() {
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM prestamo");
			while (rs.next()) {
				Prestamo p = new Prestamo();
				p.setId(rs.getInt("id"));
				p.setUsuario(ModeloUsuario.select(rs.getInt("id_usuario")));
				p.setLibro(ModeloLibro.selectId(rs.getInt("id_libro")));
				p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				p.setFechaLimite(rs.getDate("fecha_limite"));
				p.setEntregado(rs.getBoolean("entregado"));
				listaPrestamos.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaPrestamos;
	}

	public Prestamo selectPorIds(int idUsuario, int idLibro) {
		Prestamo prestamo = null;

		Statement st;
		try {
			st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM prestamo WHERE id_usuario = ('" + idUsuario
					+ "') AND id_libro = ('" + idLibro + "')");
			rs.next();
			prestamo = new Prestamo();
			prestamo.setId(rs.getInt("id"));
			prestamo.setUsuario(ModeloUsuario.select(rs.getInt("id_libro")));
			prestamo.setLibro(ModeloLibro.selectId(rs.getInt("id_libro")));
			prestamo.setFechaPrestamo(rs.getDate("fecha_prestamo"));
			prestamo.setFechaLimite(rs.getDate("fecha_limite"));
			prestamo.setEntregado(rs.getBoolean("entregado"));
			prestamo = new Prestamo();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prestamo;
	}

	public java.sql.Date dateToSql(Date fecha) {
		java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());

		return sqlDate;
	}
}
