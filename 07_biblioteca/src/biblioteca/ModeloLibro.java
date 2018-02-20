package biblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ModeloLibro extends Conector {
	public ArrayList<Libro> selectAll() {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM libros");
			while (rs.next()) {
				Libro l = new Libro(rs.getInt("id"), rs.getString("autor"), rs.getString("titulo"));
				listaLibros.add(l);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaLibros;
	}

	public static Libro selectId(int id) {
		Libro libro = new Libro();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM libros WHERE id= " + id);
			rs.next();
			libro.setId(rs.getInt("id"));
			libro.setAutor(rs.getString("autor"));
			libro.setTitulo(rs.getString("titulo"));
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return libro;
	}

	public void delete(int id) {
		try {
			Statement st = conexion.createStatement();
			st.executeQuery("DELETE FROM libros WHERE id = " + id);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Libro selectPorTitulo(String titulo) {
		Libro libro = null;
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM libros WHERE titulo= ('" + titulo + "')");
			rs.next();
			libro = new Libro(rs.getInt("id"), rs.getString("autor"), rs.getString("titulo"));
			// devolver lista

		} catch (SQLException e) {
		}
		return libro;
	}

	public void update(Libro libro) {
		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("UPDATE libros SET titulo = ? autor = ? WHERE id = ?");
			pst.setString(2, libro.getAutor());
			pst.setString(1, libro.getTitulo());
			pst.setInt(3, libro.getId());
			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(Libro libro) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO libros (autor, titulo) values (?,?)");
			pst.setString(1, libro.getAutor());
			pst.setString(2, libro.getTitulo());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void mostrarLibros(ArrayList<Libro> libros) {
		Iterator<Libro> i = libros.iterator();
		while (i.hasNext()) {
			Libro libro = i.next();
			this.mostrarLibro(libro);
		}

	}

	public void mostrarLibro(Libro libro) {
		System.out.println("ID: " + libro.getId() + "\nTitulo: " + libro.getTitulo() + "\nAutor: " + libro.getAutor());
	}
}
