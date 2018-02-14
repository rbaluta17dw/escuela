package vista;

import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.*;

public class LibroVista {
	final int INSERTAR = 1;
	final int LISTAR = 2;
	final int SALIR = 3;

	public void menuLibro() {
		Scanner scan = new Scanner(System.in);

		ModeloLibro ml = new ModeloLibro();

		int opcion;
		do {
			ArrayList<Libro> libros = ml.selectAll();
			System.out.println("--Menu de Libros--");
			System.out.println(INSERTAR + "-Insertar un libro");
			System.out.println(LISTAR + "-Listar los libros");
			System.out.println(SALIR + "-Salir");
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case INSERTAR:
				ml.insert(crearLibro());
				break;
			case LISTAR:
				ml.mostrarLibros(libros);
				break;
			case SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion mal");
				break;
			}
		} while (opcion != SALIR);
		scan.close();
	}

	public Libro crearLibro() {
		Libro libro = new Libro();
		Scanner scan = new Scanner(System.in);

		System.out.println("Escribe el titulo de un libro");
		String titulo = scan.nextLine();
		libro.setTitulo(titulo);
		System.out.println("Escribe el nombre del autor del libro");
		String autor = scan.nextLine();
		libro.setAutor(autor);
		scan.close();
		return libro;

	}
}
