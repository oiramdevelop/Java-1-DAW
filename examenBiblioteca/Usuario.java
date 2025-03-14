package examenBiblioteca;

import java.util.ArrayList;

public class Usuario {
	/*************************************
	 * VARIABLES MIEMBRO
	 *************************************/
	private int idUsuario; // Identificador único del usuario
	private String nombre; // Nombre del usuario
	private String tipo; // Tipo de usuario (estudiante, profesor, visitante)
	private ArrayList<Libro> librosPrestados; // Lista de libros prestados (máximo 3)

	/*************************************
	 * CONSTRUCTORES
	 *************************************/
	// Constructor vacío que inicializa valores predeterminados
	public Usuario() {
		this.idUsuario = (int) (Math.random() * 1000);
		this.nombre = "";
		this.tipo = "visitante";
		this.librosPrestados = new ArrayList<>();
	}

	// Constructor con parámetros para crear un usuario con datos específicos
	public Usuario(int idUsuario, String nombre, String tipo) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.tipo = tipo;
		this.librosPrestados = new ArrayList<>();
	}

	/*************************************
	 * METODOS
	 *************************************/
	// Método para prestar un libro si el usuario no supera el límite de 3
	public boolean prestarLibro(Libro libro) {
		if (librosPrestados.size() < 3) {
			librosPrestados.add(libro);
			libro.setPrestado(true);
			return true;
		}
		return false;
	}

	// Método para devolver un libro prestado
	public boolean devolverLibro(int idLibro) {
		for (Libro libro : librosPrestados) {
			if (libro.getIdentificador() == idLibro) {
				librosPrestados.remove(libro);
				libro.setPrestado(false);
				return true;
			}
		}
		return false;
	}

	// Método toString para mostrar la información del usuario
	@Override
	public String toString() {
		return "Usuario:" + "\n************************************" + "\nNombre: " + nombre + "\nID Usuario: "
				+ idUsuario + "\nTipo: " + tipo + "\nLibros prestados: " + librosPrestados.size()
				+ "\n************************************";
	}

	/*************************************
	 * GETTERS AND SETTERS
	 *************************************/
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}
}
