package vista;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import biblioteca.*;

public class PrestamosVista {

	final int INSERTAR = 1;
	final int ENTREGAR = 2;
	final int LISTAR = 3;
	final int SALIR = 4;

	public void menuPrestamo() {

		Scanner scan = new Scanner(System.in);

		ModeloPrestamo mp = new ModeloPrestamo();

		int opcion;
		do {
			ArrayList<Prestamo> prestamos = mp.selectAll();
			System.out.println("--Menu de Prestamos--");
			System.out.println(INSERTAR + "-Tomar un prestamo");
			System.out.println(ENTREGAR + "-Entregar un prestamo");
			System.out.println(LISTAR + "-Listar los prestamos");
			System.out.println(SALIR + "-Salir");
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case INSERTAR:
				mp.insert(crearPrestamo());
				break;
			case ENTREGAR:
				mp.update(entregarLibro());
				break;
			case LISTAR:
				mostrarPrestamos(prestamos);
				break;
			case SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion mal...");
				break;
			}

		} while (opcion != SALIR);
	}

	public void mostrarPrestamos(ArrayList<Prestamo> prestamos) {
		Iterator<Prestamo> i = prestamos.iterator();
		while (i.hasNext()) {
			Prestamo prestamo = i.next();
			this.mostrarPrestamo(prestamo);
		}
	}

	public void mostrarPrestamo(Prestamo prestamo) {
		String entregado;
		if (prestamo.isEntregado()) {
			entregado = "entregado";
		} else {
			entregado = "por entregar";
		}
		System.out.println("ID: " + prestamo.getId() + "\nTitulo : " + prestamo.getLibro().getTitulo() + "\nDNI : "
				+ prestamo.getUsuario().getDni() + "\nFecha Prestamo: " + prestamo.getFechaPrestamo()
				+ "\nFecha Limite: " + prestamo.getFechaLimite() + "\nEntregado: " + entregado);
	}

	public Prestamo crearPrestamo() {
		Libro libro = pedirLibroPorTitulo();
		if (libro != null) {
			Prestamo prestamo = new Prestamo();
			prestamo.setLibro(libro);
			Usuario usuario = pedirUsuarioPorDni();
			if (usuario != null) {
				prestamo.setUsuario(usuario);
				Date fechaPrestamo = new Date();
				prestamo.setFechaPrestamo(fechaPrestamo);
				prestamo.setFechaLimite(fechaLimite(fechaPrestamo));
				prestamo.setEntregado(false);
				return prestamo;
			} else {
				System.out.println("El DNI no existe");
				crearPrestamo();
				return null;
			}
		} else {
			System.out.println("El libro no existe");
			crearPrestamo();
			return null;
		}
	}

	public Prestamo entregarLibro() {
		// pedir DNI
		Usuario usuario = pedirUsuarioPorDni();
		// pedir titulo
		Libro libro = pedirLibroPorTitulo();
		// conseguir el prestamo de la BBDD
		Prestamo prestamo = pedirPrestamoPorIds(usuario.getId(), libro.getId());
		// cambiar el objeto prestamo a entregado
		prestamo.setEntregado(true);
		return prestamo;
	}

	public Libro pedirLibroPorTitulo() {
		ModeloLibro ml = new ModeloLibro();
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Escribe el nombre de un libro?");
		String titulo = scan.nextLine();
		Libro libro = ml.selectPorTitulo(titulo);
		return libro;
	}

	public Prestamo pedirPrestamoPorIds(int idUsuario, int idLibro) {
		ModeloPrestamo mp = new ModeloPrestamo();
		Prestamo prestamo = mp.selectPorIds(idUsuario, idLibro);
		return prestamo;
	}

	public Usuario pedirUsuarioPorDni() {
		Scanner scan = new Scanner(System.in);
		ModeloUsuario mu = new ModeloUsuario();
		System.out.println("Escribe tu DNI");
		String dni = scan.nextLine();
		Usuario usuario = mu.selectPorDni(dni);
		return usuario;
	}

	public Date fechaLimite(Date fechaPrestamo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaPrestamo);
		cal.add(Calendar.DATE, 21);
		Date fechaLimite = new Date();
		fechaLimite = cal.getTime();
		return fechaLimite;

	}

	public java.sql.Date dateToSql(Date fecha) {
		java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());

		return sqlDate;
	}

}
