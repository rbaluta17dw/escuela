package vista;

import biblioteca.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class UsuarioVista {
	final int INSERTAR = 1;
	final int ELIMINAR = 2;
	final int LISTAR = 3;
	final int SALIR = 4;

	public void menuUsuario() {

		Scanner scan = new Scanner(System.in);

		ModeloUsuario mu = new ModeloUsuario();
		
		int opcion;
		int id;
		do {
			ArrayList<Usuario> usuarios = mu.selectAll();
			System.out.println("--Menu de Usuarios--");
			System.out.println(INSERTAR + "-Insertar un usuario");
			System.out.println(ELIMINAR + "-Eliminar un usuario");
			System.out.println(LISTAR + "-Listar los usuarios");
			System.out.println(SALIR + "-Salir");
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case INSERTAR:
				 mu.insert(crearUsuario());
				break;
			case ELIMINAR:
				mostrarUsuarios(usuarios);
				System.out.println("Dame el id para eliminar");
				id = Integer.parseInt(scan.nextLine());
				mu.delete(id);
				break;
			case LISTAR:
				mostrarUsuarios(usuarios);
				break;
			case SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion mal...");
				break;
			}

		} while (opcion != SALIR);
		scan.close();
	}

	public void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		Iterator<Usuario> i = usuarios.iterator();
		while (i.hasNext()) {
			Usuario usuario = i.next();
			this.mostrarUsuario(usuario);
		}
	}

	public void mostrarUsuario(Usuario usuario) {
		System.out.println("ID: " + usuario.getId() + "\nNombre: " + usuario.getNombre() + "\nApellido: "
				+ usuario.getApellido() + "\nEdad: " + usuario.getEdad()+ "\nDNI: " + usuario.getDni() + "\nFecha nacimiento: " + usuario.getFechaNacimineto());
	}

	public Usuario crearUsuario() {
		Usuario usuario = new Usuario();
		Scanner scan = new Scanner(System.in);
		System.out.println("Dame un nombre");
		String nombre = scan.nextLine();
		usuario.setNombre(nombre);
		System.out.println("Dame un apellido");
		String apellido = scan.nextLine();
		usuario.setApellido(apellido);
		System.out.println("Dame una edad");
		int edad = Integer.parseInt(scan.nextLine());
		usuario.setEdad(edad);
		System.out.println("Dame un dni");
		String dni = scan.nextLine();
		usuario.setDni(dni);
		Date fechaNacimiento;
		try {
			System.out.println("Dame una fecha de nacimiento");
			String fecha = scan.nextLine();
			SimpleDateFormat df = new SimpleDateFormat("yyyyy-MM-dd");
			fechaNacimiento = df.parse(fecha);
			usuario.setFechaNacimineto(fechaNacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
		return usuario;
	}
}
